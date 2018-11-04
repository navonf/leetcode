class Solution {
    public int numJewelsInStones(String J, String S) {
        int jewels = 0;
        HashSet<Character> jewelSet = new HashSet<Character>();
        for(char c : J.toCharArray())
            jewelSet.add(c);
        
        for(char c : S.toCharArray())
            jewels += jewelSet.contains(c) ? 1 : 0;
        
        return jewels;
    }
}
