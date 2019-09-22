class Solution {
    public int titleToNumber(String s) {
        // references from letter to number.
        int[] bet = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        
        // incremental length.
        int length = s.length();
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // if its not the last letter: 26^(s.legnth-1) * that letter
            // else: (it is the last num) add just the letter
            sum += i != s.length()-1 ? Math.pow(26, length - 1) * bet[s.charAt(i) - 'A'] : bet[s.charAt(i) - 'A'];
            
            // decrement length to corresponding with letter index.
            length--;
        }
        
        return sum;
    }
}
