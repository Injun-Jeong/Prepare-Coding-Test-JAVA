package goorm;

import java.io.*;

public class Q53763 {
    private static BufferedReader br;
    private static int N, K;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        int result = (N - 1) % (K - 1) == 0 ? (N - 1) / (K - 1) : (N - 1) / (K - 1) + 1;
        System.out.println( result );
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        // 무쓸모
        input = br.readLine();
    }
}
