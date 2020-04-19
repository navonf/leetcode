class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                
                // if we get here make a new array, starting with 1, 
                // the rest of the indicies with 0's
                if (i == 0) {
                    digits = new int [digits.length+1];
                    digits[0] = 1;
                    return digits;
                }
            }
            else {
                digits[i] += 1;
                break;
            }
        }
        
        return digits;
    }
}
