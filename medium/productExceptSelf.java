class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        
        for(int i = 0; i < nums.length; i++) {
            output[i] *= prod;
            prod *= nums[i];
        }
        
        prod = 1;
        
        for(int i = nums.length-1; i >= 0; i--) {
            output[i] *= prod;
            prod *= nums[i];
        }
        
        return output;
    }
}
