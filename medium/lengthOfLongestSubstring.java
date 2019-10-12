class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i = 0, j = 0;
        
        Set<Character> set = new HashSet<>();
        
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                
                maxLength = set.size() > maxLength ? set.size() : maxLength;
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLength;
    }
}
