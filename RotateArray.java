class Solution {
    public void rotate(int[] nums, int k) {
        
        // O(n*k) Solution.
        for(int rotations = 0; rotations < k; rotations++) {
            int next = 0;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                
                if(i == 0) {
                    // put the last number in the array in the beggining. 
                    next = nums[0];
                    nums[0] = nums[nums.length-1];
                }
                else {
                    temp = nums[i];
                    nums[i] = next;
                    next = temp;
                }
                
            }
        }
        
    }
}
