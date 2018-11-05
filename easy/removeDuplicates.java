class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) 
            return 0;
        
        int i = 0;
        // j will iterate faster throughout the nums array,
        // checking if nums[i] and nums[j] are the same.
        for(int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        // return i+1 because i was the last index we were at.
        // adding one gives us the length of the array
        return i+1;
    }
}
