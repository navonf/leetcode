/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // case for one list is null and the other isn't.
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // make new heads so we can start the OG head at the samller value.
        ListNode head = null;
        ListNode otherHead = null;
        if(l1.val < l2.val) {
            head = l1;
            otherHead = l2;
        }
        else {
            head = l2;
            otherHead = l1;
        }
        
        // save the reference to the OG head for returning.
        ListNode headCopy = head;
        
        // traverse until at least one list is null.
        // if one list is at null, the rest of the other list is greater than it.
        while(head != null && otherHead != null) {
            // make sure you're not checking a null next node, and then compare.
            if(head.next != null && 
              (head.next.val < otherHead.val)) {
                // the next node is lesser than the other list's node.
                // just iterate since its sorted.
                head = head.next;
            }
            // otherHead is greater
            else {
                // save head.next, we'll need to replace it with otherHead later.
                ListNode temp = null;
                temp = head.next;
                
                // connect head to otherHead.
                head.next = otherHead;
                head = otherHead;
                
                // replace otherHead
                otherHead = temp;
                
                // at this point, the nodes should be back to 
                // the original state for comparison.
            }
        }
        
        // return the OG head reference.
        return headCopy;
    }
}
