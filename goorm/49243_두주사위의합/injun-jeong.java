package goorm;

import java.io.*;

public class Q49243 {
    private static BufferedReader br;
    private static int K;

    public static void main(String[] args) throws Exception {
        setup();
        getAnswer();
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
    }

    private static void getAnswer() {
        for (int first = 1; first <= 6; first++) {
            for (int second = 1; second <= 6; second++) {
                if ( first + second == K ) {
                    System.out.println(first + " " +second);
                }
            }
        }
    }
}
