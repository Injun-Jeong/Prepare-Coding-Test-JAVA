package goorm.devth;

import java.io.*;

public class Q03 {
    private static BufferedReader br;
    private static long T, N, M, answer;

    public static void main(String[] args) throws Exception {
        init();
        for (int cnt = 0; cnt < T; cnt++) {
            setup();
            getAnswer();
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());
    }

    private static void setup() throws IOException {
        answer = 0l;
        String input = br.readLine();
        String[] inputs = input.split(" ");
        N = Long.parseLong(inputs[0]);
        M = Long.parseLong(inputs[1]);
    }

    private static void getAnswer() {
        long n = N;
        long m = M;

        long tempN = n / 5;
        long tempM = m / 7;

        if ( tempN < tempM ) {
            answer += tempN;
        } else {
            answer += tempM;

            tempN = n - (tempM * 5);
            tempM = m % 7;

            if (tempN + tempM >= 12) {
                answer++;
                tempN = tempN - (12 - tempM);
                answer += tempN / 12;
            }
        }

        System.out.println(answer);
    }
}
