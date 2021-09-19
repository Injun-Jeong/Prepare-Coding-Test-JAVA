package goorm;

import java.io.*;

public class Q43068 {
    private static BufferedReader br;
    private static int N;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* get answer */
        getAnswer();
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
    }

    private static void getAnswer() throws IOException {
        for (int cnt = 0; cnt < N; cnt++) {
            String input = br.readLine();
            String[] inputs = input.split(" ");

            if ( isOk(inputs) ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isOk(String[] inputs) {
        int a = Math.abs(Integer.parseInt(inputs[0]));
        int b = Math.abs(Integer.parseInt(inputs[1]));
        int n = Integer.parseInt(inputs[2]);

        if ( a + b > n ) {
            return false;
        } else if ( (n - (a + b)) % 2 == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
