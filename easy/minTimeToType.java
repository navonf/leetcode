class Solution {
    public int minTimeToType(String word) {
        int totalDistance = 0;
        int currentPosition = 97;
        
        for (int i = 0; i < word.length(); i++) {
            int curChar = (int) word.charAt(i);           
            int rightDistance = Math.abs(curChar - currentPosition);
            int leftDistance = 26 - Math.abs(currentPosition - curChar);
            
            totalDistance += Math.min(rightDistance, leftDistance) + 1;
            currentPosition = curChar; // move character 
        }
        
        return totalDistance;
    }
}
