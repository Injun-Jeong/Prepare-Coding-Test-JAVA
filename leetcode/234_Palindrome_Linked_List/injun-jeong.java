package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q234_Palindrome_Linked_List {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
        }

        return true;
    }
}
