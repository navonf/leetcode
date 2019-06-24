class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
            digits[digits.length-1] = digits[digits.length-1] + 1;
        }
        else {
            boolean hasRoomInArray = true;
            for(int i = digits.length-1; i >= 0; i--) {
                if(digits[i] == 9) {
                    System.out.println(digits);
                    digits[i] = 0;
                }
                else {
                    digits[i] = digits[i] + 1;
                    hasRoomInArray = false;
                    break;
                }
            }
            
            if(hasRoomInArray) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        
        return digits;
    }
}
