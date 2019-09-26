/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        
        q.offer(node);
        
        while(!q.isEmpty()) {
            // poll our leading node in the queue.
            Node curr = q.poll();
            
            // mark as visited.
            set.add(curr.val);
            
            // make a deep copy of that node, if it doesnt exist in the map already.
            Node currCopy = null;
            if(!map.containsKey(curr.val)) {
                currCopy = new Node(node.val, new LinkedList<Node>());
            }
            // if it does exist, then retrieve it.
            else {
                currCopy = map.get(curr.val);
            }
            
            // bfs it's neighbors.
            for(Node n : curr.neighbors) {
                // if we have not visited it yet, offer it to the queue.
                if(!set.contains(n.val)) {
                    set.add(n.val);
                    q.offer(n);
                }
                
                // add it's neighbors, if it does exist, then retrieve it.
                if(map.containsKey(n.val)) {
                    Node temp = map.get(n.val);
                    currCopy.neighbors.add(temp);
                }
                // if it doesn't exist, create a new one.
                else {
                    Node temp = new Node(n.val, new LinkedList<Node>());
                    map.put(temp.val, temp);
                    currCopy.neighbors.add(temp);
                }
            }
            
            if(!map.containsKey(currCopy.val)) {
                map.put(curr.val, currCopy);
            }
        }
        
        
        return map.get(node.val);
    }
}
