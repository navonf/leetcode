class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        
        int i = 1;
        while(i < k) {
            pq.poll();
            i++;
        }
        
        return pq.peek();
    }
}
