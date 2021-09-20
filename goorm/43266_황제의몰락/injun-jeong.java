package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43266 {
    private static BufferedReader br;
    private static int N, K;
    private static List<Integer> list;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* suicide */
        suicide();


        /* result */
        printResult();
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        list = new ArrayList<>();
        for (int idx = 0; idx < N; idx++) {
            list.add(idx);
        }
    }

    private static void suicide() {
        int turn = 0;

        while (list.size() > 2) {
            list.remove(turn);
            turn = ((turn - 1) + K) % list.size();
        }
    }

    private static void printResult() {
        list.set(0, list.get(0) + 1);
        list.set(1, list.get(1) + 1);
        System.out.println(list.get(0) + " " + list.get(1));
    }
}
