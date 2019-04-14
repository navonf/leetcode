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
    public int maxAncestorDiff(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int maxDiff = 0;
        
        while(root != null || !s.isEmpty()) {
            if(root != null) {
                
                Stack<TreeNode> innerStack = new Stack<>();
                TreeNode temp = root;
                while(root != null  || !innerStack.isEmpty()) {
                    if(root != null) {
                        int diff = Math.abs(temp.val - root.val);
                        if(maxDiff < diff) {
                            maxDiff = diff;
                        }
                        innerStack.push(root);
                        root = root.left;
                    }
                    else {
                        root = innerStack.pop();
                        root = root.right;
                    }
                }
                // reset root.
                root = temp;
                
                s.push(root);
                root = root.left;
            }
            else {
                root = s.pop();
                root = root.right;
            }
        }
        
        return maxDiff;
    }
}
