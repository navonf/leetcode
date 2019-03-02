/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> q1 = new LinkedList<>();
        List<TreeNode> q2 = new LinkedList<>();
        
        DFS(root, q1, p);
        DFS(root, q2, q);
        
        int min = Math.min(q1.size(), q2.size());
        TreeNode lastSameNode = null;
        for(int i = 0; i < min; ++i) {
            if(q1.get(i) == q2.get(i)) {
                lastSameNode = q1.get(i);
            }
            else {
                break;
            }
        }
        
        return lastSameNode;
    }
    
    public boolean DFS(TreeNode root, List<TreeNode> q, TreeNode target) {
        if(root == null) {
            return false;
        }
        
        // process, push to stack.
        q.add(root);
        
        if(root.equals(target)) {
            return true;
        }
        
        if(DFS(root.left, q, target)) {
            return true;
        }
        
        if(DFS(root.right, q, target)) {
            return true;
        }
        
        q.remove(q.size() - 1);
        return false;
    }
}
