/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            if(a == null) {
                a = headB;
            }
            
            if(b == null) {
                b = headA;
            }
            
            if(a == b || (a == null && b == null)) {
                break;
            }
            
            a = a.next;
            b = b.next;
        }
        
        return a == b ? a : null;
    }
}
