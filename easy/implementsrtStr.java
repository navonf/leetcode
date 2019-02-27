class Solution {
    public int strStr(String haystack, String needle) {
        //base case for needle string being "".
        if(needle.length() == 0) return 0;
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int hay = i;
                boolean good = true;
                for(int j = 0; j < needle.length(); j++) {
                    // case that the hay is smaller than needle, so it can't contain it.
                    if(hay >= haystack.length()) {
                        return -1;
                    }
                    
                    if(haystack.charAt(hay) != needle.charAt(j)) {
                        good = false;
                    }
                    hay++;
                }
                
                // we made it through the check fully, return we found it at position i.
                if(good) return i;
            }
        }
        
        // went through and didn't find match.
        return -1;
    }
}
