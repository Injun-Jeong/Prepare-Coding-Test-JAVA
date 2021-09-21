package goorm.devth;

import java.io.*;

// 5:00~
public class Q04 {
    private static BufferedReader br;
    private static long N, K, answer;

    public static void main(String[] args) throws Exception {
        setup();
        getAnswer();
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Long.parseLong(inputs[0]);
        K = Long.parseLong(inputs[1]);
    }


    /*
    fir + sec + ?
    <=> ? where (N - fir - sec) % N = 0
     */
    private static void getAnswer() {
        long temp = 0l;
        for (long first = 0; first <= N - K; first++) {
            for (long second = first + 1; second <= N - K + 1; second++) {
                temp = (N - first - second) % N;
                if ( second < temp ) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
