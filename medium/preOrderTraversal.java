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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            if(root != null) {
                pre.add(root.val);
                s.push(root);
                root = root.left;
            }
            else {
                root = s.pop();
                root = root.right;
            }
        }
        
        return pre;
    }
}
