class Solution {
    public String frequencySort(String s) {
        if(s.equals("")) return "";
        
        // Map to store character frequencies.
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray()) {
            // the character exists, just update the freq
            if(map.containsKey(c)) {
                int freq = map.get(c);
                map.put(c, ++freq);
            }
            else {
                int freq = 1;
                map.put(c, freq);
            }
        }
        
        // Point.y will store frequencies of the characters.
        PriorityQueue<Point> pq = new PriorityQueue<Point>(
            map.size(),
            new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return Integer.compare(p2.y, p1.y);
                }
            }
        );
        
        // store each <key, value> pair in the map, into our priority queue.
        map.forEach(
            (letter, freq) -> {
                pq.offer(new Point(letter, freq));
            }
        );
        
        // build the new sorted string.
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            char letter = (char) p.x;
            int freq = p.y;
            
            for(int i = 0; i < freq; i++) {
                sb.append(letter);
            }
        }
        
        return sb.toString();
    }
}
