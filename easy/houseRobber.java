class Solution {
    public int rob(int[] nums) {
        int evenSum = 0;
        int oddSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum = Math.max(evenSum + nums[i], oddSum);
            }
            else {
                oddSum = Math.max(oddSum + nums[i], evenSum);
            }
        }
        return Math.max(evenSum, oddSum);
    }
}
