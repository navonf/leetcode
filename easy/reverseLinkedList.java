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
        // in the cases of:
        // 1 -> null, return 1
        // null, return null
        if(head == null || head.next == null) {
            return head;
        }
        
        // to reverse this linkedlist, we're going to want
        // to change the direction in which the current node 
        // is pointing to the next node.
        
        // this means if 1 -> 2 -> null, we want:
        // null <- 1 <- 2, which reverses the list, return the head
        
        // before loop
        // to do this, we must start at our head, save it's CURRENT next,
        // then, point the current head to null.
        
        // in iteration loop
        // after we enter the loop to iterate through the list,
        // we want to point the current node, to that old next that we saved.
        
        // looking something like this:
        // null <- 1 <- 2 (current node)
        
        
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode prev = curr;
        
        curr.next = null;
        curr = next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
    }
}
