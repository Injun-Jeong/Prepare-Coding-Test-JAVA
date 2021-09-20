package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q43250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String input = br.readLine();
        String[] inputs = input.split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);

        input = br.readLine();
        inputs = input.split(" ");
        for ( int idx = 0; idx < A; idx++ ) {
            list.add(Integer.parseInt(inputs[idx]));
        }

        input = br.readLine();
        inputs = input.split(" ");
        for ( int idx = 0; idx < B; idx++ ) {
            list.add(Integer.parseInt(inputs[idx]));
        }

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        String result = "";
        if ( !collect.isEmpty() ) {
            for (int idx = 0; idx < collect.size(); idx++) {
                result = result.concat(collect.get(idx).toString()).concat(" ");
            }
            System.out.println(result);
        }
    }
}
