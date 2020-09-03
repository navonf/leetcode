class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        // we have a left and right pointer, starting on respective sides
        // of the string. if at a valid character, for both, and they are
        // equal, increment left and decrement right.
        while (left < right) {
            // check if invalid character?
            if (!isValidCharacter(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValidCharacter(s.charAt(right))) {
                right--;
                continue;
            }
            
            // tolower both, check equality
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // check if c is alphanumeric
    private boolean isValidCharacter(char c) {
        return 
            (48 <= c && c <= 57) ||
            (65 <= c && c <= 90) || 
            (97 <= c && c <= 122);
    }
}
