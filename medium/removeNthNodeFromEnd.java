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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode ogHead = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // this is the case if n == number of nodes
        if (fast == null) {
            return head.next;
        }
        
        while (fast.next != null) {
            head = head.next;
            fast = fast.next;
        }
        
        head.next = head.next.next;

        return ogHead;
    }
}
