package leetcode;

public class Q005_LongestPalindromicSubstring {    // medium
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int start = 0, end = 0, len1, len2, len;
        for (int i = 0; i < s.length(); i++) {
            len1 = expandAroundCenter(s, i, i);
            len2 = expandAroundCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(left) == s.charAt(R)) {
            L--;
            R++;
        }
        return right - left + 1;
    }
}
