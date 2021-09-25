package leetcode;

public class Q009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        String[] input = Integer.toString(x).split("");
        String rev = "";
        for (int idx = 0; idx < input.length; idx++) {
            rev = rev.concat(input[input.length - 1 - idx]);
        }

        return Integer.toString(x).equals(rev);
    }
}
