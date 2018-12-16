class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
        
        for(int num : nums) {
            pq.offer(num);
        }
        
        for(int i = 0; i < k-1; i++) {
            pq.poll();
        }
        
        return pq.peek();
    }
}
