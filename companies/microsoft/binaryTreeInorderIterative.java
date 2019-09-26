/**
 * traversal: [8,4,9,2,5,1,6,3,7]
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
        // inorder traversal: left, root, right.
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        
        return list;
    }
}
