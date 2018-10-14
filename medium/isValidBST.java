/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isValidBST {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);

        if(list.size() == 1) return true;

        int prev = Integer.MIN_VALUE;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i-1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            inOrder(root.left, list);
        }

        list.add(root.val);

        if(root.right != null) {
            inOrder(root.right, list);
        }
    }
}
