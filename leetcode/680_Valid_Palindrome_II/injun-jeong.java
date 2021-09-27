package leetcode;

public class Q680_Valid_Palindrome_II {
    public boolean validPalindrome(String str) {
        return isPalindrome(0, str.length() - 1, str, true);
    }

    private boolean isPalindrome(int start, int end, String str, boolean couldDelete) {
        for (int left = start, right = end; left < right; left++, right--) {
            if (str.charAt(left) == str.charAt(right)) {
                continue;
            } else if ( couldDelete ) {
                return isPalindrome(left + 1, right, str, false)
                        || isPalindrome(left, right - 1, str, false);
            } else {
                return false;
            }
        }
        return true;
    }
}
