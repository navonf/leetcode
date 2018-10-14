/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class listInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inord(list, root);
        return list;
    }

    private void inord(ArrayList<Integer> list, TreeNode root) {
        if(root == null) return;

        if(root.left != null) {
            inord(list, root.left);
        }

        list.add(root.val);

        if(root.right != null) {
            inord(list, root.right);
        }
    }
}
