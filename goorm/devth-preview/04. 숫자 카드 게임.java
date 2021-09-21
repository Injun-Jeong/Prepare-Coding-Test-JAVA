package goorm.devth;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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


    private static void getAnswer() {
        List<Long> list = new ArrayList<>();
        combination(list, 0);
        System.out.println(answer);
    }


    private static void combination(List<Long> list, long item) {
        if (list.size() == K) {
            if ( isOk(list) ) {
                answer = (answer + 1) % 1000000007l;
            }
            return;
        }

        if ( item >= N ) {
            return;
        }

        // include
        List<Long> deepCopy = new ArrayList<>(list);
        deepCopy.add(item);
        combination(deepCopy, item + 1l);

        // no way
        combination(list, item + 1l);
    }


    private static boolean isOk(List<Long> list) {
        long sum = 0l;
        for (int idx = 0; idx < list.size(); idx++) {
            sum += list.get(idx);
        }
        return sum % N == 0;
    }
}
