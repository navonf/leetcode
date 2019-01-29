class Solution {
    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] list = new int[A.length];
        int i = 0;
        
        for(int n : A) {
            pq.add((n*n));
        }
        
        while(!pq.isEmpty()) {
            list[i] = pq.poll();
            i++;
        }
        
        return list;
    }
}
