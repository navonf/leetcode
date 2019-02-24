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
        // map reference for deep copy.
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        
        // bfs visited reference.
        HashSet<Node> visited = new HashSet<Node>();
        
        // bfs queue.
        Queue<Node> q = new LinkedList<Node>();

        q.offer(node);
        visited.add(node);
        
        Node rootNode = new Node(node.val, new LinkedList<Node>());
        
        for(Node n : node.neighbors) {
            // System.out.println(n.val);
            Node newNode = new Node(n.val, new LinkedList<Node>());
            map.put(n.val, newNode);
            rootNode.neighbors.add(newNode);
        }
        
        map.put(rootNode.val, rootNode);
        
        while(!q.isEmpty()) {
            Node currOld = q.poll();
            
            // we already did the rootNode so add all neighbors except rootNode.
            if(rootNode.val != currOld.val) {
                Node newNode = 
                    map.containsKey(currOld.val) ? 
                    map.get(currOld.val) :
                    new Node(currOld.val, new LinkedList<Node>());

                // add it's neighbors
                for(Node n : currOld.neighbors) {
                    // we already have in map.
                    if(map.containsKey(n.val)) {
                        newNode.neighbors.add(map.get(n.val));
                    }
                    // we don't have in map.
                    else {
                        Node temp = new Node(n.val, new LinkedList<Node>());
                        map.put(n.val, temp);
                        newNode.neighbors.add(temp);
                    }
                }
            }
            
            // bfs to another node.
            for(Node n : currOld.neighbors) {
                if(!visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }
        }
        
        // debug.
        // map.forEach((key, val) -> {
        //    System.out.println("Node: " + val + ": children " + val.neighbors);
        // });
        
        return rootNode;
    }
}
