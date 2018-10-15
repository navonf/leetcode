/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderLists {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();

        if(root == null) {
            return bigList;
        }

        q.offer(root);

        while(!q.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            List<Integer> smallList = new ArrayList<Integer>();

            while(!q.isEmpty()) {
                nodeList.add(q.poll());
            }

            for(TreeNode n : nodeList) {
                if(n.left != null) {
                    q.offer(n.left);
                }

                if(n.right != null) {
                    q.offer(n.right);
                }

                smallList.add(n.val);
            }

            bigList.add(smallList);
        }

        return bigList;
    }
}
