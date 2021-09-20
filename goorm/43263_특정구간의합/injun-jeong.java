package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43263 {
    private static BufferedReader br;
    private static int N;
    private static List<Integer> list;

    public static void main(String[] args) throws Exception {
        setup();
        getAnswer();
    }

    private static void setup() {
        br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        list.add(0);
    }

    private static void getAnswer() throws IOException {
        String input = br.readLine();
        N = Integer.parseInt(input);

        input = br.readLine();
        String[] inputs = input.split(" ");
        for ( int idx = 0; idx < N; idx++ ) {
            list.add(Integer.parseInt(inputs[idx]));
        }

        input = br.readLine();
        inputs = input.split(" ");
        int answer = 0;
        for (int idx = Integer.parseInt(inputs[0]); idx <= Integer.parseInt(inputs[1]); idx++) {
            answer += list.get(idx);
        }

        System.out.println(answer);
    }
}
