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

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { // find the middle
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse slow --> tail
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // jump between head (original half) and prev lists
        while (prev != null) {
            ListNode n1 = head.next;
            ListNode n2 = prev.next;

            head.next = prev;
            prev.next = n1;

            head = n1;
            prev = n2;
        }
    }
}
// ex. 2 4 6 8
// slow = 4
// ex. 2 4 6 8 10
// slow = 6