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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestNums = new ArrayList<>();
        
        if(root == null) {
            return largestNums;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode n1, TreeNode n2) {
                    if(n1.val > n2.val) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            });
            
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                pq.offer(node);
            }
            
            largestNums.add(pq.peek().val);
            
            while(!pq.isEmpty()) {
                TreeNode curr = pq.poll();
                
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
        }
        
        return largestNums;
    }
}
