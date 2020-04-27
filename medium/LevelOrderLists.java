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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return list;
        }
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
            list.add(level);
        }
        
        return list;
    }
}
