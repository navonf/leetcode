class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] mostFrequentElements = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<element> maxHeap = new PriorityQueue<element>(
            nums.length,
            (e1, e2) -> Integer.compare(e2.freq, e1.freq)
        );
//         PriorityQueue<element> maxHeap = new PriorityQueue<element>(nums.length, new Comparator<element>() {
//                 @Override
//                 public int compare(element e1, element e2) {
//                     /*** Long way: ***
                    
//                     // negative num sorts (moves) elements to the front
//                     if (e1.freq > e2.freq) {
//                         return -1;
//                     }
//                     // positive num sorts (moves) elements to the back
//                     else if (e1.freq < e2.freq) {
//                         return 1;
//                     }
//                     return 0;
                    
//                     */
                    
//                     /*** Shorter **
//                     return Integer.compare(e2.freq, e1.freq);
//                     */
//                 }
//             }
//         );
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, ++freq);
            }
            else {
                map.put(num, 1);
            }
        }
        
        map.forEach((key, val) -> {
            maxHeap.offer(new element(key, val));
        });
        
        for (int i = 0; i < k; i++) {
            mostFrequentElements[i] = maxHeap.poll().num;
        }
        
        return mostFrequentElements;
    }
}

class element {
    int num;
    int freq;
    
    element(int n, int f) {
        this.num = n;
        this.freq = f;
    }
}
