package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1249_Minimum_Remove_to_Make_Valid_Parentheses {
    private String answer;
    private String[] inputs;
    private Map<String, Integer> stock;

    public String minRemoveToMakeValid(String s) {
        setup(s);
        countParentheses();
        getAnswer();
        return answer;
    }


    private void setup(String s) {
        answer = "";
        inputs = s.split("");
        stock = new HashMap<>();
    }


    private void countParentheses() {
        for (String input: inputs) {
            if ( input.equals(")")) {
                stock.put(input, stock.getOrDefault(input, 0) + 1);
            }
        }
    }


    private void getAnswer() {
        List<String> stack = new ArrayList<>();

        for (String input: inputs) {
            if ( input.equals("(") ) {
                if ( stock.getOrDefault(")", 0) <= 0 ) {
                    continue;
                } else {
                    stack.add("(");
                    stock.put(")", stock.getOrDefault(")", 0) - 1);
                    answer = answer.concat("(");
                }
            }
            else if ( input.equals(")") ) {
                if ( stack.isEmpty() ) {
                    stock.put(")", stock.getOrDefault(")", 0) - 1);
                    continue;
                }
                else {
                    stack.remove(0);
                    answer = answer.concat(")");
                }
            }
            else {
                answer = answer.concat(input);
            }
        }
    }
}
