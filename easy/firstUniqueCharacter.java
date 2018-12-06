class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        
        // keep track of frequencies of each character.
        // Point.x = will keep track of the freq.
        // Point.y = will keep track of the location in the string.
        Point[] freq = new Point[26];
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new Point(0, 0);
        }
        
        // for example,
        // if a letter 'e' in "leetcode" will have it's index in the freq array look like:
        // [..., Point(3, 7), ...]
        // it appears 3 times, and it's last occurence is at 7.
        // this is just an example, we only care about a letter with 1 freq.
        
        // iterate through string, incrementing the freqs and noting position in string.
        for(int i = 0; i < s.length(); i++) {
            // x will keep track of freq.
            freq[ s.charAt(i) - 'a' ].x++;
            // y will keep track of location.
            freq[ s.charAt(i) - 'a' ].y = i;
        }
        
        // iterate again to get the first occurence of a unique character.
        for(int i = 0; i < s.length(); i++) {
            if(freq[ s.charAt(i) - 'a' ].x == 1) {
                return freq[ s.charAt(i) - 'a' ].y;
            }
        }
        
        return -1;
    }
}
