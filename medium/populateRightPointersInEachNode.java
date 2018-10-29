/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        ArrayDeque<TreeLinkNode> q = new ArrayDeque<TreeLinkNode>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
            
            while(!q.isEmpty()) {
                list.add(q.poll());
            }
            
            TreeLinkNode prev = null;
            
            for(TreeLinkNode n : list) {
                if(prev != null) {
                    prev.next = n;
                    prev = n;
                }
                else {
                    prev = n;
                }
                
                if(n.left != null) {
                    q.offer(n.left);
                }
                
                if(n.right != null) {
                    q.offer(n.right);
                }
            }
            
            prev.next = null;            
        }
    }
}
