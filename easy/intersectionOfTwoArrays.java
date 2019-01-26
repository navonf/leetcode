class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        // put first numbers in hashmap
        for(int num : nums1) {
            if(map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, ++count);
            }
            else {
                map.put(num, 1);
            }
        }
        
        for(int num : nums2) {
            if(map.containsKey(num)) {
                list.add(num);
                
                int count = map.get(num);
                
                // if count is 1
                if(count == 1) {
                    // remove it from the map.
                    map.remove(num);
                }
                // if count > 1
                else {
                    map.put(num, --count);
                }
            }
        }
        
        int[] l = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            l[i] = list.get(i);
        }
        
        return l;
    }
}
