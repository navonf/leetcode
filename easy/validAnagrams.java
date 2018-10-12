class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        
        for(char c : s.toCharArray()) {
            // put the letter in the index, increment counter.
            freq[c - 'a']++;
        }
        
        for(char c : t.toCharArray()) {
            // put the letter in the index, increment counter.
            freq2[c - 'a']++;
        }
        
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != freq2[i]) return false;
        }
        
        return true;
    }
}
