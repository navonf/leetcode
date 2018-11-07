class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        
        // they're all in ascending order return the first element.
        return nums[0];
        
    }
}
