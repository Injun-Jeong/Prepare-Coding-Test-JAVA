package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Q206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if ( Objects.isNull(head) ) {
            return head;
        }

        ListNode cntNode = head;
        ListNode newHead = null;
        while(true) {
            ListNode node = new ListNode(cntNode.val);
            node.next = newHead;
            newHead = node;

            if ( Objects.isNull(cntNode.next) ) {
                break;
            } else {
                cntNode = cntNode.next;
            }
        }

        return newHead;
    }
}
