/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || (head != null && head.next == null)) {
            return head;
        }
        
        ListNode first = head;
        ListNode prev  = head;
        ListNode next  = head.next.next;
        head = head.next;
        
        while(next != null) {
            ListNode newNext = next.next;
            head.next = prev;
            prev = head;
            head = next;
            next = newNext;
        }
        
        // handle the last one.
        head.next = prev;
        first.next = null;
        
        return head;
    }
}
