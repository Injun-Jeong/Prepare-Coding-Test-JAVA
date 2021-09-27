package leetcode;

public class Q125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        String parsedLowerCase = getParsedLowerCase(s);
        return getResult(parsedLowerCase);
    }


    private String getParsedLowerCase(String str) {
        String[] s = str.split("[^a-zA-Z0-9]");
        String parsed = "";
        for (String item: s) {
            parsed = parsed.concat(item);
        }

        String parsedLowerCase = "";
        for (int idx = 0; idx < parsed.length(); idx++) {
            parsedLowerCase = parsedLowerCase.concat(String.valueOf(Character.toLowerCase(parsed.charAt(idx))));
        }

        return parsedLowerCase;
    }


    private boolean getResult(String str) {
        for (int left = 0, right = str.length() - 1; left < right; left++, right--) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
