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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return dfs(root.left, root.right);
    }
    
    // falses
    // node1.val != node2.val
    // node1 == null && node2 != null
    // node1 =! null && node2 == null
    
    // trues
    // node1.val == node2.val
    // node1.left == node2.right
    // node1.right == node2.left
    
    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {
            return false;
        }
        
        return node1.val == node2.val &&
            dfs(node1.left, node2.right) &&
            dfs(node1.right, node2.left);
    }
}
