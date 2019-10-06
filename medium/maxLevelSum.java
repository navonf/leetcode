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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int maxSum = 0;
        int maxLvl = 0;
        int level = 1;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
            int sum = sumList(list);
            if(sum > maxSum) {
                maxSum = sum;
                maxLvl = level;
            }
            
            level++;
        }
        
        return maxLvl;
    }
    
    public int sumList(List<Integer> l) {
        int sum = 0;
        for(int num : l) {
            sum += num;
        }
        return sum;
    }
}
