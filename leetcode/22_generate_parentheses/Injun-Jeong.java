package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q022_Generate_Parentheses {
    List<String> result;
    int N;

    public List<String> generateParenthesis(int n) {
        N = n;
        result = new ArrayList<>();

        getResult(0, new Stack<>(), "");

        return result;
    }

    private void getResult(int cnt, Stack<String> stack, String parentheses) {
        if (cnt == N * 2) {
            if (stack.isEmpty()) {
                result.add(parentheses);
            }
            return;
        }

        stack.push("(");
        getResult(cnt + 1, (Stack<String>) stack.clone(), parentheses.concat("("));
        stack.pop();

        if ( !stack.isEmpty() && "(".equals(stack.peek())) {
            stack.pop();
            getResult(cnt + 1, (Stack<String>) stack.clone(), parentheses.concat(")"));
        } else {
            return;
        }
    }
}
