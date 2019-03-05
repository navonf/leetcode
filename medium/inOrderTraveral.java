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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } 
            else {
                root = s.pop();
                list.add(root.val);
                root = root.right; 
            }
        }

        return list;
    }
    
}
