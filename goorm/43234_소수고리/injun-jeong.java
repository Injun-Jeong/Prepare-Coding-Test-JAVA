package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43234 {
    private static ArrayList<List<Integer>> answers;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /* logic start line */
        setup(input);

        List<Integer> answer = new ArrayList<>();
        // 시작은 무조건 1부터
        int num = list.remove(0);
        answer.add(num);

        findAnswer(answer, new ArrayList<>(list));

        printAnswer();
        /* logic end line */
    }


    private static void setup(String input) {
        /* init instant variable */
        answers = new ArrayList<List<Integer>>();
        list = new ArrayList<Integer>();
        int inputNum = Integer.parseInt(input);
        for (int num = 1; num <= inputNum; num++) {
            list.add(num);
        }
    }


    private static void findAnswer(List<Integer> answer, List<Integer> subList) {
        if ( subList.isEmpty() ) {
            if ( isOk(answer.get(answer.size() - 1), answer.get(0), answer.get(1)) ) {
                answers.add(answer);
            }
            return;
        }

        int num;
        for (int idx = 0; idx < subList.size(); idx++) {
            num = subList.remove(idx);
            if (answer.size() < 2) {
                List<Integer> newAnswer = new ArrayList<>(answer);
                newAnswer.add(num);
                findAnswer(newAnswer, new ArrayList<>(subList));
            } else if ( isOk( answer.get(answer.size() - 2), answer.get(answer.size() - 1), num) ) {
                List<Integer> newAnswer = new ArrayList<>(answer);
                newAnswer.add(num);
                findAnswer(newAnswer, new ArrayList<>(subList));
            }

            subList.add(idx, num);
        }
    }


    private static boolean isOk(int a, int b, int c) {
        int num = b + a;

        if ( ! isPrimeNumber(num) ) {
            return false;
        }

        num = b + c;

        if ( ! isPrimeNumber(num) ) {
            return false;
        }

        return true;
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 2) {
            return true;
        }

        for (int d = 2; d < (num + 1) / 2; d++) {
            if ( num % d == 0 ) {
                return false;
            }
        }

        return true;
    }


    private static void printAnswer() {
        for (List<Integer> list : answers) {
            String answer = list.get(0).toString();

            for (int idx = 1; idx < list.size(); idx++) {
                answer = answer.concat(" ").concat(list.get(idx).toString());
            }
            System.out.println(answer);
        }
    }
}
