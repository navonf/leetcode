class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; 
        int j = 0;
        int added = 0;
        
        while(i < (m+added) && j < nums2.length) {
            System.out.println(Arrays.toString(nums1) + ", i: " + i + ", j: " + j);
            if(nums1[i] <= nums2[j]) {
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                for(int idx = nums1.length-1; idx > i; idx--) {
                    nums1[idx] = nums1[idx-1];
                }
                nums1[i] = nums2[j];
                i++;
                added++;
                j++;
            }
        }
        
        if(j < n) {
            for(int idx = i; idx < nums1.length; idx++) {
                nums1[idx] = nums2[j];
                j++;
            }
        }
            
    }
}
