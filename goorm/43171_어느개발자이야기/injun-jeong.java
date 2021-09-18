package goorm;

import java.io.*;

public class Q43171 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /* logic start line */
        getAnswer(input);
        /* logic start line */
    }

    private static void getAnswer(String input) {
        /* find max digit */
        String[] digits = input.split("");
        int maxDigit = findMaxDigit(digits);

        /* find answer */
        for (int n = maxDigit + 1; n <= Integer.MAX_VALUE; n++) {
            int num = conversionToTen(digits, n);

            if ( isSqrt(num) ) {
                System.out.println(Integer.toString(n));
                return;
            }
        }

        System.out.println("");
    }

    private static int findMaxDigit(String[] digits) {
        int maxDigit = 0;
        for ( String digit : digits ) {
            maxDigit = maxDigit < Integer.parseInt(digit) ? Integer.parseInt(digit) : maxDigit;
        }

        return maxDigit;
    }

    private static int conversionToTen(String[] digits, int N) {
        int num = 0;

        int base;
        int idx;
        for (int cnt = 0; cnt < digits.length; cnt++) {
            idx = (digits.length - 1) - cnt;
            base = (N * cnt) == 0 ? 1 : (N * cnt);
            num += ( Integer.parseInt(digits[idx]) * base );
        }

        return num;
    }

    private static boolean isSqrt(int num) {
        Double sqrt = Math.sqrt(num);
        return sqrt == sqrt.intValue();
    }
}
