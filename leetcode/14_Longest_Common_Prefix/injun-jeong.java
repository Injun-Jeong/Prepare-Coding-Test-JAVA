package leetcode;

public class Q14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int idx = 1; idx < strs.length; idx++) {
            while ( strs[idx].indexOf(prefix) != 0 ) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
