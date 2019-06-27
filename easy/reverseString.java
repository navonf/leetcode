class Solution {
    public void reverseString(char[] s) {
        int low = 0;
        int hi = s.length - 1;
        char temp = 'a';
        
        while(low < hi) {
            temp = s[low];
            s[low] = s[hi];
            s[hi] = temp;
            
            low++;
            hi--;
        }
    }
}
