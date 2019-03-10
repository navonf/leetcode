class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = nums.length / 2;
        
        // map of <number, frequency>
        for(int num : nums) {
            if(map.containsKey(num)) {
                int freq = map.get(num) + 1;
                if(freq > majority) {
                    return num;
                }
                map.put(num, freq);
            }
            else {
                map.put(num, 1);
            }
        }
        
        return 0;
    }
}
