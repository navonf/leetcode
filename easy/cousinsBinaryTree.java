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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            // Our map data will contain <ValueOfNode, ParentValueOfNode>
            Map<Integer, Integer> map = new HashMap<>();
            
            // copy the queue, so we're not offering back to the same queue.
            Queue<TreeNode> tempQ = new LinkedList<>(); 
            Iterator<TreeNode> it = q.iterator();
            while(it.hasNext()) {
               tempQ.offer(it.next());
            }
            
            while(!tempQ.isEmpty()) { 
                TreeNode parent = tempQ.poll();
                q.poll();
                
                // add children
                if(parent.left != null) {
                    TreeNode leftChild = parent.left;
                    map.put(leftChild.val, parent.val);
                    q.offer(leftChild);
                }
                if(parent.right != null) {
                    TreeNode rightChild = parent.right;
                    map.put(rightChild.val, parent.val);
                    q.offer(rightChild);
                }
                // System.out.println("end: " +tempQ);
            }
            
            // debug
            // System.out.println("level");
            // map.forEach((k,v) -> {
            //    System.out.println("k: " +k+", v: " + v);
            // });
            
            // remember that this map is everything on this level, so we've already
            // made sure we're on the same level. this will short circut 
            if(map.containsKey(x) && map.containsKey(y) && map.get(x) != map.get(y))
                return true;
        }
        
        return false;
    }
}


