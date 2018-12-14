class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Map to reference processes.
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        // Linked lists are faster at adding.
        List<Integer> killList = new LinkedList<Integer>();
        
        // Queue for BFS traversal.
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        
        // Init map, storing { parent : children }
        for(int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            
            // no need to make array if it has it just add
            if(map.containsKey(ppid.get(i))) {
                ArrayList<Integer> list = map.get(parent);
                list.add(pid.get(i));
                map.put(parent, list);
            }
            else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(pid.get(i));
                map.put(parent, list);
            }
        }
        
        // the process to kill, will startup the traversal.
        q.offer(kill);
        
        // BFS
        while(!q.isEmpty()) {
            // Add it to kill list.
            int proc = q.poll();
            killList.add(proc);
            
            // only queue up children, if they exist.
            if(map.get(proc) != null) {
                ArrayList<Integer> list = map.get(proc);
                
                // add all children to queue.
                for(int child : list) {
                    q.offer(child);
                }
            }
        }
        
        return killList;
    }
}
