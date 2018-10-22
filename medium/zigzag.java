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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // An ArrayDeque gives us both environments for a 
        // queue or stack, we can execute either functions.
        // This is how we will achieve our zig zag.
        ArrayDeque<TreeNode> deq = new ArrayDeque<TreeNode>();
        // Final list to return.
        List<List<Integer>> bigL = new ArrayList<List<Integer>>();
        
        // empty..
        if(root == null) return bigL;
        
        // insert first node.
        deq.offer(root);
        
        // run operations until the deque is empty.
        // once it is empty, this means we have gone through
        // all nodes of the tree.
        boolean toggle = true;
        while(!deq.isEmpty()) {
            ArrayDeque<TreeNode> deqInside = new ArrayDeque<TreeNode>();
            List<Integer> smallL = new ArrayList<Integer>();
            
            if(toggle) {
                while(!deq.isEmpty()) {
                    deqInside.offer(deq.pollLast());
                }
            }
            else {
                while(!deq.isEmpty()) {
                    deqInside.offer(deq.pollFirst());
                }
            }
            
            // perform queue opertions (in order)
            if(toggle) {
                while(!deqInside.isEmpty()) {
                    TreeNode temp = deqInside.pollFirst();
                    if(temp.left != null) {
                        deq.offer(temp.left);
                    }
                    if(temp.right != null) {
                        deq.offer(temp.right);
                    }
                    smallL.add(temp.val);
                }
            }
            else {
                while(!deqInside.isEmpty()) {
                    TreeNode temp = deqInside.pollLast();
                    if(temp.right != null) {
                        deq.offer(temp.right);
                    }
                    if(temp.left != null) {
                        deq.offer(temp.left);
                    }
                    smallL.add(temp.val);
                }
            }
            
            // flip the toggle, perform the other operations next.
            toggle = !toggle;
            
            bigL.add(smallL);
        }
        
        for(List<Integer> l : bigL) {
            System.out.println(l);
        }
        
        return bigL;
    }
}
