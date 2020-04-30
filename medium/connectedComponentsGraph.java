class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        int connectedComponentGroups = 0;
        
        // create the nodes
        for (int node = 0; node < n; node++) {
            graph.put(node, new Node(node));
        }
    
        // build their children/edges
        for (int[] nodes : edges) {
            Node n1 = graph.get(nodes[0]);
            Node n2 = graph.get(nodes[1]);
            n1.children.add(n2);
            n2.children.add(n1);
        }
        
        // bfs from each node, if it's been visited already then we've already
        // traversed this connected component group
        for (int node = 0; node < n; node++) {
            Node currNode = graph.get(node);
            
            if (!currNode.visited) {
                // bfs
                Queue<Node> q = new LinkedList<>();                
                q.offer(currNode);
                
                while (!q.isEmpty()) {
                    currNode = q.poll();
                    currNode.visited = true;
                    for (Node child : currNode.children) {
                        if (!child.visited) {
                            q.offer(child);
                        }
                    }
                }
                
                connectedComponentGroups++;
            }
        }
        return connectedComponentGroups;
    }
}

class Node {
    public int id;
    public List<Node> children;
    // went with a visited property instead of using a set of n nodes. reducing memory
    public boolean visited;
    public Node(int id) {
        this.id = id;
        this.children = new LinkedList<Node>();
        this.visited = false;
    }
}
