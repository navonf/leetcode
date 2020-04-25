class Solution {
    // [5,5,1,1,1,1,1]
    public int maxArea(int[] height) {
        int maxWater = 0;
        int l = 0;
        int r = height.length - 1;
        
        while (l < r) {
            int water = (r - l) * Math.min(height[l], height[r]);
            if (water > maxWater) {
                maxWater = water;
            }
            
            if (height[l] > height[r]) {
                r--;
            }
            else {
                l++;
            }
        }
        return maxWater;
    }
}
