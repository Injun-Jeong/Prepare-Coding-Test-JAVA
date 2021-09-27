package leetcode;


public class Q1047_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;

        for (char character : str.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }

        return sb.toString();
    }
}
