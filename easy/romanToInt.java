class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        
        Map<Character, Character> matches = new HashMap<>();
        matches.put('V', 'I');
        matches.put('X', 'I');
        matches.put('L', 'X');
        matches.put('C', 'X');
        matches.put('D', 'C');
        matches.put('M', 'C');
        
        int sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(i == 0) {
                sum += romans.get(c);
            }
            else {
                if(c == 'V' || c == 'X') {
                    if(matches.get(c) == s.charAt(i - 1)) {
                        sum -= 1;
                        i--;
                    }
                }
                else if(c == 'L' || c == 'C') {
                    if(matches.get(c) == s.charAt(i - 1)) {
                        sum -= 10; 
                        i--;
                    }
                }
                else if(c == 'D' || c == 'M') {
                    if(matches.get(c) == s.charAt(i - 1)) {
                        sum -= 100; 
                        i--;
                    }
                }
                sum += romans.get(c);
            }
        }
        return sum;
    }
}
