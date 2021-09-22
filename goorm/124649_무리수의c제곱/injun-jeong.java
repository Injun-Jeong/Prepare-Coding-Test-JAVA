package goorm;

import java.io.*;

public class Q124649 {
    private static BufferedReader br;
    private static long A, B, C;
    private static double answer;

    public static void main(String[] args) throws Exception {
        setup();
        getAnswer();
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        A = Long.parseLong(inputs[0]);
        B = Long.parseLong(inputs[1]);
        C = Long.parseLong(inputs[2]);
        answer = 0;
    }

    private static void getAnswer() {
        double base = A + Math.sqrt(B);
        answer = Math.pow(base, C);
        System.out.println((long) answer);
    }
}
