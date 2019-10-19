class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1] < target) return nums.length;
        
        int ret = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                ret = i;
                break;
            }
        }
        
        return ret;
    }
}
