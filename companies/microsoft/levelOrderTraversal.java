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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<TreeNode> innerQ = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            // process the current row 
            List<Integer> innerList = new ArrayList<Integer>();
            
            while(!q.isEmpty()) {
                TreeNode curr = q.poll();
                innerList.add(curr.val);

                if(curr.left != null) {
                    innerQ.offer(curr.left);
                }

                if(curr.right != null) {
                    innerQ.offer(curr.right);
                }
            }
            
            list.add(innerList);
            
            while(!innerQ.isEmpty()) {
                q.offer(innerQ.poll());
            }
        }
        
        return list;
    }
}
