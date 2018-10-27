/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry = 0;
        
        // put vals into a stack.
        // sum = (l1.val + l2.val + carry) % 10 = this is the value to put in the node
        // sum = 9 + 1 + 0 = 10... 10 % 10 == 0
        // then we take this value,
        // sum / 10 = carry, which is 1.
        // in tradiational addiction 9 + 1, is 10, so our node is 0, and carry the 1
        while(l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry) % 10;
            ListNode node = new ListNode(sum);
            carry = (l1.val+ l2.val + carry) / 10;
            // now, connect the node.
            l3.next = node;
            // iterate all nodes.
            l3 = l3.next;
            l2 = l2.next;
            l1 = l1.next;
        }
        
        // here we may have 1 list longer than the other.
        // set a node to the current spot where we left 
        // off at in the longer list.
        ListNode nonEmptyListNode = new ListNode(0);
        if(l1 != null) {
            nonEmptyListNode = l1;
        }
        else if(l2 != null) {
            nonEmptyListNode = l2;
        }
        
        // it is possible that one of the lists may be longer than the other.
        // we need to, empty out that list, adding the carry as we go.
        if(l1 != null || l2 != null) {
            while(nonEmptyListNode != null) {
                int sum = (nonEmptyListNode.val + carry) % 10;
                ListNode node = new ListNode(sum);
                carry = (nonEmptyListNode.val + carry) / 10;
                // now, we can connect.
                l3.next = node;
                l3 = l3.next;
                // iterate.
                nonEmptyListNode = nonEmptyListNode.next;
            }
        }
        
        // set the end of the other list to our leftover carry
        // in the case of: 9 > 9 > 9 > 9 = 00001 == 10,000
        if(carry > 0) {
            ListNode tail = new ListNode(carry);
            l3.next = tail;
            tail.next = null;
        }
        
        return head.next;
    }

}
