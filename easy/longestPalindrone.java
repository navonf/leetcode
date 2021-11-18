class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }
        
        int len = 0;
        
        for (Character key : map.keySet()) {
            int count = map.get(key);
            if (count > 1) {
                if (count % 2 == 0) {
                    len += count;
                    map.put(key, 0);
                } else {
                    len += count - 1;
                    map.put(key, 1);
                }
            }
        }
        
        return map.values().contains(1) ? ++len : len;
    }
}
