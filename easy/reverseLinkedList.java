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
    
    /* 
    prev pointer = null, one pointer on curr node
    save ref to curr.next
    point curr.next to prev
    iterate prev, so prev = curr
    iterate curr, so curr = temp (which was next)
    */
    
    public ListNode reverseList(ListNode head) {
        // handle single node edge case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        
        while (head != null) {
            ListNode tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        
        return prev;
    }
}
