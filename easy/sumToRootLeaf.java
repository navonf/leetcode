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
    
    public int sumRootToLeaf(TreeNode root) {
        return pathSum(root, 0);
    }
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        
        sum = 2 * sum + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        
        return pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}
