class Solution {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c : keyboard.toCharArray()) {
            map.put(c, i++);
        }
        
        int sum = map.get(word.charAt(0));
        for(i = 1; i < word.length(); i++) {
            sum += Math.abs(map.get(word.charAt(i))
                        - map.get(word.charAt(i-1)));
        }

        return sum;
    }
}
