class SingleNumber {
    public static void main(String args[]) {

        int[] a = {1};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        int[] freq = new int[nums.length+1];
        int ret = 0;

        // Update frequency.
        for(int curr : nums)
            freq[curr]++;

        for(int i = 0; i < nums.length; i++) {
            if(freq[i] == 1)
                ret = i;
        }

        return ret;
    }
}
