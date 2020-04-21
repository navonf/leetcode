class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            // bypass dupes 
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            
            if (j < nums.length) {
                nums[i+1] = nums[j];
                len = i+2;
            }
        }
        return len;
    }
}
