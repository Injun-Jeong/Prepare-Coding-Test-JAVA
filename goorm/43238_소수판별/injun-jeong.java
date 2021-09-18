package goorm;

import java.io.*;

public class Q43238 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /* logic start line */
        if ( input.equals("2") ) {
            System.out.println("True");
        } else {
            getAnswer(Integer.parseInt(input));
        }
        /* logic end line */
    }

    private static void getAnswer(int inputNumber) {
        for (int num = 2; num < (inputNumber + 1) / 2; num++) {
            if ( inputNumber % num == 0 ) {
                System.out.println("False");
                return;
            }
        }

        System.out.println("True");
    }
}
