/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode referenceToNewList = new RandomListNode(0);
        RandomListNode current = referenceToNewList;
        RandomListNode newNode = null;
        
        while(head != null) {
            
            // check if we have already created the node we want to create,
            // if we have not, create it
            if(!map.containsKey(head)) {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            } else {
                newNode = map.get(head);
            }

            // we check to make sure that the random node exists.            
            if(head.random != null) {
                
                // check to see if we have already created the new node,
                // if we havent, create it
                if(!map.containsKey(head.random)) {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                } else {
                    newNode.random = map.get(head.random);
                }
            }
            
            current.next = newNode;
            current = current.next;
            head = head.next;
        }
        
        return referenceToNewList.next;
    }
}


