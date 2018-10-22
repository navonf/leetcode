/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }
    
    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p != null && q == null) return false;
        else if(q != null && p == null) return false;
        else if(p.val == q.val) {
            return check(p.left, q.left) && check(p.right, q.right);
        }
        
        return false;
    }
}