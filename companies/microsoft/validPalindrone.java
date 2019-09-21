class Solution {
    public boolean isPalindrome(String s) {
        // two pointers used to traverse simultaneously from
        // the beginning and end of the string.
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            if(!isAlphaNum(s.charAt(i))) {
                i++;
                continue;
            }
            if(!isAlphaNum(s.charAt(j))) {
                j--;
                continue;
            }
            
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));
                
            if(c1 != c2) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isAlphaNum(char c) {
        // convert c to an ASCII value.
        int ascii = c;
        
        // valid ranges of alphanumeric ascii values.
        if((ascii >= 48 && ascii <= 57) || 
           (ascii >= 65 && ascii <= 90) ||
           (ascii >= 97 && ascii <= 122)) {
            return true;
        }
            
        return false;
    }
}
