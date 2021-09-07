package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Q017_Letter_Combinations_of_a_Phone_Number {
    String[] letters = "abc/def/ghi/jkl/mno/pqrs/tuv/wxyz".split("/");
    Set<String> result;

    public List<String> letterCombinations(String digits) {
        result = new HashSet<>();

        if ( digits.isEmpty() ) {
            return result.stream().collect(Collectors.toList());
        }

        getResult(digits, 0, "");

        return result.stream().collect(Collectors.toList());
    }

    private void getResult(String digits, int digitIdx, String currLetters) {
        if (digitIdx >= digits.length()) {
            result.add(currLetters);
            return;
        }

        int digit = Integer.parseInt( Character.toString(digits.charAt(digitIdx)) );
        String[] lettersOfDigit = letters[digit - 2].split("");

        for ( String letter : lettersOfDigit ) {
            getResult(digits, digitIdx + 1, currLetters.concat(letter));
        }
    }
}
