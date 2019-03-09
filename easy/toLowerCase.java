class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            int charInAscii = (int) str.charAt(i);
            
            // that means its a capital letter
            if(65 <= charInAscii && charInAscii <= 90) {
                charInAscii += 32;
            }
            
            char c = (char) charInAscii;
            sb.append(c);
        }
        
        return sb.toString();
    }   
}
