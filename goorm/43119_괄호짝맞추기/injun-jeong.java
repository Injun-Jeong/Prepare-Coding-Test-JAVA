package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 5:19 ~
public class Q43119 {
    private static BufferedReader br;
    private static List<String> stack;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* logic start */
        start();
    }

    private static void setup() {
        br = new BufferedReader(new InputStreamReader(System.in));
        stack = new ArrayList<>();
    }

    private static void start() throws IOException {
        String input = br.readLine();
        String[] inputs = input.split("");

        String item;
        for (String s : inputs) {
            if (s.equals(")")) {
                item = stack.remove(stack.size() - 1);
                if (!item.equals("(")) {
                    System.out.println("False");
                    return;
                }
            } else if (s.equals("}")) {
                item = stack.remove(stack.size() - 1);
                if (!item.equals("{")) {
                    System.out.println("False");
                    return;
                }
            } else if (s.equals("]")) {
                item = stack.remove(stack.size() - 1);
                if (!item.equals("[")) {
                    System.out.println("False");
                    return;
                }
            } else {
                stack.add(s);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
