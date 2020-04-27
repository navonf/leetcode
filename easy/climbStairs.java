class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n];
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        // n = 1
        steps[0] = 1;
        
        // n = 2
        steps[1] = 2;
        
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        
        return steps[n-1];
    }
}
