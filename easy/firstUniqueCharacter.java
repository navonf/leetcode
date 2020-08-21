class Solution {
    public int firstUniqChar(String s) {
        if (s == "" || s == null) {
            return -1;
        }
        
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            // c - 'a' gives us the 0th based index.
            // increment frequency of character.
            freq[c - 'a']++;
        }
        
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return idx; 
            }
            idx++;
        }
        
        return -1;
    }
}
