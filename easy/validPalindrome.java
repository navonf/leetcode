class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        // check letters until i surpasses j
        while(i < j) {
            // check out of bounds, and alphanum. if not increase i
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            // check out of bounds, and alphanum. if not decrease j
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            // check if the same, if not return false
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            
            i++;
            j--;
        }
        return true;
    }
}
