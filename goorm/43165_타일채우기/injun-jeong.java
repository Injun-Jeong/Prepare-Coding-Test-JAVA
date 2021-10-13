package goorm;

import java.io.*;

public class Q43165 {
    private static BufferedReader br;
    private static int N, M;
    private static int[] answer;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* get answer */
        getAnswer();

        /* result */
        System.out.println(answer[N - 1] % M);
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        answer = new int[N];
    }

    private static void getAnswer() {
        answer[0] = 1;
        if (N == 1) {
            return;
        }
        answer[1] = 3;

        for (int idx = 2; idx < N; idx++) {
            answer[idx] = answer[idx - 1] + (answer[idx - 2] * 2);
        }
    }
}
