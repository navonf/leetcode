/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // head is null, create a new list.
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        Node max = head;
        
        while (max.next != head && max.val <= max.next.val) {
            max = max.next;
        }
        
        Node min = max.next;
        
        if (insertVal >= max.val || insertVal <= min.val) {
            Node node = new Node(insertVal);
            max.next = node;
            node.next = min;
            return head;
        }
        
        Node iter = min;
        
        while (iter != max) {
            if (iter.val <= insertVal && insertVal <= iter.next.val) {
                Node node = new Node(insertVal, iter.next);
                iter.next = node;
                break;
            }
            iter = iter.next;
        }
        
        return head;
    }
}
