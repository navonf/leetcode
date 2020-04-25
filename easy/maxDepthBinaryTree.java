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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
    
    public int bfs(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;    
        }
        
        Queue<TreeNode> q = new LinkedList<>();        
        q.offer(root);
        
        while (!q.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()) {
                temp.offer(q.poll());
            }
            
            while(!temp.isEmpty()) {
                TreeNode curr = temp.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
