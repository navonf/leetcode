class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j = 0;
        
        while (j < nums.length) {
            if (nums[j] <= nums[i]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        
        return i + 1;
    }
}


/*
nums.length = 3
i = 0
j = 0
[1,1,1]           

- while j less than nums length
    - if j item less than or equal to i item
        - keep going 
        - put j item at i + 1, iterate i
*/
