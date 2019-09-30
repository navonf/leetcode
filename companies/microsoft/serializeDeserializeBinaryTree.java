/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        
        if(root != null) {
            q.add(root);
        }
        
        while(!q.isEmpty()) {
            Queue<TreeNode> q2 = new ArrayDeque<>();
            while(!q.isEmpty()) {
                q2.offer(q.poll());
            }
            
            while(!q2.isEmpty()) {
                TreeNode temp = q2.poll();
                String rootNum = Integer.toString(temp.val) +":";
                String leftString = "";
                String rightString = "";
                
                if(temp.left != null) {
                    q.offer(temp.left);
                    leftString = rootNum + Integer.toString(temp.left.val) +",";
                }
                else {
                    leftString = rootNum + "x,";
                }
                
                if(temp.right != null) {
                    q.offer(temp.right);
                    rightString = rootNum + Integer.toString(temp.right.val) +",";
                }
                else {
                    rightString = rootNum + "x,";
                }
                
                sb.append(leftString + rightString);
            }
        }
        sb.setLength(sb.length());
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(data);
        
        int end = sb.indexOf(":");
        int rootNum = Integer.parseInt(sb.substring(0, end));
        TreeNode root = new TreeNode(rootNum);
        TreeNode rootRef = root;
        q.offer(rootRef);
        
        
        while(!q.isEmpty()) {
            Queue<TreeNode> q2 = new ArrayDeque<>();
            while(!q.isEmpty()) {
                q2.offer(q.poll());
            }
            
            while(!q2.isEmpty()) {
                TreeNode curr = q2.poll();
                
                PeelPair leftPair = peelChild(sb);
                if(leftPair == null) {
                    curr.left = null;
                    sb.delete(0,4);
                }
                else {
                    curr.left = new TreeNode(leftPair.num);
                    q.offer(curr.left);
                    sb = leftPair.sb;
                }
                
                PeelPair rightPair = peelChild(sb);
                if(rightPair == null) {
                    curr.right = null;
                    sb.delete(0,4);
                }
                else {
                    curr.right = new TreeNode(rightPair.num);
                    q.offer(curr.right);
                    sb = rightPair.sb;
                }
            }
        }
        
        
        return root;
    }
    
    public PeelPair peelChild(StringBuilder sb) {
        int start = sb.indexOf(":");
        if(sb.charAt(start+1) == 'x') {
            return null;
        }
        
        String num = "";
        int i = 0;
        sb.delete(0, start+1);

        while(sb.charAt(i) != ',') {
            num = num.concat(sb.substring(i, i+1));
            sb.delete(0, 1);
        }
        sb.delete(0, 1);
        
        return new PeelPair(sb, Integer.parseInt(num));
    }
}

class PeelPair {
    public StringBuilder sb;
    public int num;
    
    public PeelPair(StringBuilder stb, int n) {
        this.sb = stb;
        this.num = n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
