class Solution {
    public int findDuplicate(int[] nums) {
        // You must not modify the array (assume the array is read only).
        // You must use only constant, O(1) extra space.
        // Your runtime complexity should be less than O(n2).
        // There is only one duplicate number in the array, but it could be repeated more than once.    
        int max = -999;
        int maxNum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int localMax = 0;
            for(int j = i; j < nums.length; j++) {
                // if the numbers are the same, increase count.
                if(nums[i] == nums[j])
                    localMax++;
            }
            
            if(localMax > max) {
                max = localMax;
                maxNum = nums[i];
            }
        }
        
        return maxNum;
        
    }
}
