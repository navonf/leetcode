/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // empty case.
        if(head == null) return null;
        
        // 2 queues, lists would've worked.
        // i like queues, because they're easily emptied. 
        ArrayDeque<ListNode> qEven = new ArrayDeque<ListNode>();
        ArrayDeque<ListNode> qOdd = new ArrayDeque<ListNode>();
        // count for even/odd.
        int count = 1;
    
        // put in every node in correct queue.
        while(head != null) {
            if(count % 2 == 0) {
                qEven.offer(head);
            }
            else {
                qOdd.offer(head);
            }
            
            head = head.next;
            count++;
        }
        
        // poll the first node to start list.
        // save reference.
        ListNode newHead = qOdd.poll();
        ListNode ret = newHead;
        
        // empty odd queue.
        while(!qOdd.isEmpty()) {
            // add to list.
            newHead.next = qOdd.poll();
            // iterate.
            newHead = newHead.next;
        }
        
        
        // empty even queue.
        while(!qEven.isEmpty()) {
            // add to list.
            newHead.next = qEven.poll();
            //iterate.
            newHead = newHead.next;
        }
        
        // Set the last node's next to null, singaling the end of the list.
        newHead.next = null;
        
        // return.
        return ret;
    }
}
