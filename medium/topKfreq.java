import java.awt.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // we already have it just update the count.
            if(map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, ++freq);
            }
            // we dont have it, init with freq of 1.
            else {
                int freq = 1;
                map.put(num, freq);
            }
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(map.size(), new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return Integer.compare(p2.y, p1.y);
                }
            }
        );
        
        map.forEach((key, val) -> {
            pq.offer(new Point(key, val));
        });
        
        int[] ans = new int[k];
 
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll().x;
        }
        
        return ans;
    }
}
