package goorm;

import java.io.*;

public class Q43244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] inputs = input.split(" ");
        String regex = "[".concat(inputs[0]).concat("]");
        String str = inputs[1].replaceAll(regex, "");

        if (str.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
