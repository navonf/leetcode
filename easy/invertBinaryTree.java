/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // start traversal.
        invert(root);
        return root;
    }
    
    public void invert(TreeNode root) {
        // we end when the function gets a root that is null.
        if (root == null) {
            return;
        }
        
        // once we realize that when we swap nodes, all the sub children
        // are also swapped, we can invert the tree easily.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // continue to invert down the tree.
        invert(root.left);
        invert(root.right);
    }
}
