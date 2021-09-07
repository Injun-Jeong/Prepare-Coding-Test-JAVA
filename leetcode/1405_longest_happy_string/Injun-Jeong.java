package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1405_Longest_Happy_String {
    Map<String, Integer> stock;
    String answer;
    String concatString;

    private void init(int a, int b, int c) {
        stock = new HashMap<>();
        stock.put("a", a);
        stock.put("b", b);
        stock.put("c", c);
        answer = "";
        concatString = "";
    }

    private void getLongestHappyString() {
        while ( isPossibleConcat() ) {
            answer = answer.concat(concatString);
            stock.replace(concatString, stock.get(concatString) - 1);
        }
    }

    private boolean isPossibleConcat() {
        boolean flag = false;
        List<String> collect = stock.keySet()
                                    .stream()
                                    .sorted((k1, k2) -> stock.get(k2) - stock.get(k1))
                                    .collect(Collectors.toList());

        for (int idx = 0; idx < 3; idx++) {
            if ( answer.length() >= 2 && answer.substring(answer.length() - 2, answer.length()).equals(collect.get(idx).concat(collect.get(idx))) ) {
                continue;
            }
            else if ( stock.get(collect.get(idx)) > 0 ) {
                concatString = collect.get(idx);
                flag = true;
                break;
            }
        }

        return flag;
    }

    public String longestDiverseString(int a, int b, int c) {
        init(a, b, c);
        getLongestHappyString();

        return answer;
    }
}
