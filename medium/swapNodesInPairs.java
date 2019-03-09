/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // null, returns null
        if(head == null) {
            return null;
        }
        
        // x -> null, returns x -> null
        if(head.next == null) {
            return head;
        }
        
        // x -> y -> null, returns y -> x -> null
        if(head.next.next == null) {
            ListNode second = head.next;
            second.next = head;
            head.next = null;
            return second;
        }
        
        
        Queue<ListNode> q = new ArrayDeque<>();
        
        while(head != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            if(second == null) {
                // odd number of nodes.
                // no swap, just add the last node.
                head = head.next;
                q.offer(first);
            }
            else {
                // do the swap
                head = head.next.next;
                second.next = first;
                first.next = null;
                
                // add to queue.
                q.offer(second);
                q.offer(first);
            }
        }
        
        // the front of our queue is our head.
        head = q.poll();
        ListNode temp = head;
        
        while(!q.isEmpty()) {
            head.next = q.poll();
            head = head.next;
        }
        
        return temp;
    }
}
