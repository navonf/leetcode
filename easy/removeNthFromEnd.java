/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        // iterate the fast pointer ahead n times
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // case if the fast is null now, case: n == length
        if (fast == null) {
            return slow.next;
        }
        
        
        ListNode prev = null;
        
        // using fast as a flag for when to stop
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        // update our prev.next to no longer point to the nth node
        prev.next = slow.next;
        
        return head;
    }
}
