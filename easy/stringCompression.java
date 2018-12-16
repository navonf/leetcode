class Solution {
    public int compress(char[] chars) {
        // Base case
        if(chars.length == 1) return 1;
        
        // tools we'll need.
        char currentChar = chars[0];
        int countRepeats = 1;
        int idx = 0;
        
        for(int i = 1; i < chars.length; i++) {
            if(currentChar == chars[i]) {
                countRepeats++;
            }
            // we have no more repeats, modify in place.
            else {
                chars[idx] = currentChar;
                idx++;
                // check if count is more than 1
                if(countRepeats > 1 && countRepeats < 10) {
                    chars[idx] = (char)(48 + countRepeats);
                    idx++;
                    countRepeats = 1;
                }
                // over 10
                else if(countRepeats >= 10) {
                    char[] num = Integer.toString(countRepeats).toCharArray();
                    System.out.println(num);
                    for(int j = 0; j < num.length; j++) {
                        chars[idx] = num[j];
                        idx++;
                    }
                    countRepeats = 1;
                }
                
                currentChar = chars[i];
            }
        }
        
        chars[idx] = chars[chars.length-1];
        idx++;
        if(countRepeats > 1 && countRepeats < 10) {
            chars[idx] = (char)(48 + countRepeats);
            idx++;
        }
        // over 10
        else if(countRepeats >= 10) {
            char[] num = Integer.toString(countRepeats).toCharArray();
            for(int j = 0; j < num.length; j++) {
                chars[idx] = num[j];
                idx++;
            }
        }
        
        return idx;
        
    }
}
