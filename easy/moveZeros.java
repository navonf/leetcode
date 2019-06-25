class Solution {
    public void moveZeroes(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int zero = nums[i];
                int swap = i;
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] == 0) {
                        continue;
                    }
                    else {
                        // save it.
                        int temp = nums[j];
                        // replace it.
                        nums[j] = zero;
                        // swap it behind.
                        nums[swap] = temp;
                        swap++;
                    }
                }
            }
        }
    }
}
