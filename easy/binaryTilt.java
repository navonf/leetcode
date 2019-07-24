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
    public int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        sumTree(root);
        return tilt;
    }

    public int sumTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
    
}
