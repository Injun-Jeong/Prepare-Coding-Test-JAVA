package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43246 {
    private static BufferedReader br;
    private static int N;
    private static List<Object> queue;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* start program */
        start();

        /* result */
        printResult();
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        queue = new ArrayList<>();
    }

    private static void start() throws IOException {
        int cnt = 0;
        String cmd;
        while (cnt < N) {
            cmd = br.readLine();
            if (cmd.equals("d") || cmd.equals("D")) {
                if (queue.isEmpty()) {
                    System.out.println("underflow");
                } else {
                    queue.remove(0);
                }
            } else if (cmd.equals("e") || cmd.equals("E")) {
                if (queue.size() == 10) {
                    System.out.println("overflow");
                } else {
                    cmd = br.readLine();
                    queue.add(Integer.parseInt(cmd));
                }
            } else {
                return;
            }
            cnt++;
        }
    }

    private static void printResult() {
        String result = "";
        if ( !queue.isEmpty() ) {
            result = result.concat(Integer.toString( (Integer) queue.get(0)));
            for (int idx = 1; idx < queue.size(); idx++) {
                result = result.concat(" ").concat(Integer.toString( (Integer) queue.get(idx)));
            }
            System.out.println(result);
        }
    }
}
