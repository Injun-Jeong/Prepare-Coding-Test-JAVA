package goorm;

import java.io.*;

public class Q43110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split("");

        String result = "";
        for (int cnt = 0; cnt < inputs.length; cnt++) {
            if (cnt % 2 == 0) {
                result = result.concat(inputs[cnt/2]);
            } else {
                result = result.concat(inputs[(inputs.length - 1) - cnt/2]);
            }
        }

        System.out.println(result);
    }
}
