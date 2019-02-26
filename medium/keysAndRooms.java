class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        ArrayDeque<Node> q = new ArrayDeque<Node>();
        int count = 0;
        
        for(int i = 0; i < rooms.size(); i++) {
            for(int j = 0; j < rooms.get(i).size(); j++) {
                int current = rooms.get(i).get(j);
                
                if(current != i) {
                    if(!map.containsKey(current)) {
                        map.put(current, new Node(current));
                    }
                    
                    if(!map.containsKey(i)) {
                        map.put(i, new Node(i));
                    }
                    
                    map.get(i).children.add(map.get(current));
                }
                else if(!map.containsKey(i)) {
                    map.put(i, new Node(i));
                }
            }
        }
        
        if(map.get(0) != null) {
            map.get(0).visited = true;
            q.offer(map.get(0));
        }
 
        while(!q.isEmpty()) {
            Node curr = q.poll();
            count++;
            
            HashSet<Node> set = curr.children;
            
            for(Node child : set) {
                if(!child.visited) {
                    child.visited =true;
                    q.offer(child);
                }
            }
        }
        
        // debug.
        // map.forEach((k, v) -> {
        //     System.out.println("key: " + k + ",node: " + v+ ", children: " + v.children);
        // });
        // System.out.println(count);
        
        return count == map.keySet().size();
    }
}

class Node {
    public int val;
    public boolean visited;
    public HashSet<Node> children;
    
    Node(int v) {
        this.val = v;
        this.visited = false;
        this.children = new HashSet<Node>();
    }
}
