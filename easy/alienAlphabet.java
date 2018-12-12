class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        /* Questions:
         * - Is it possible to recieve a null or empty words array?
         * - Is it possible to recieve a null or empty order array?
         * - Are these ASCII-based characters?
         * - Can order contains duplicates?
         *      more: meaning, 2 letters have the same magnitude? 
         */
        
        if(words.length == 1) return true;
        
        // Easy way and quick way for us to lookup alien order.
        HashMap<Character, Integer> alienAlphabet = new HashMap<Character, Integer>();
        for(int i = 0; i < order.length(); i++) {
            alienAlphabet.put(order.charAt(i), i+1);
        }
        
        // Iterate through words list
        wordSearch: for(int i = 0; i < words.length - 1; i++) {
            // Whoa, ok. This takes the smaller length of the word i, or i+1.
            // Read it like: "My first word length smaller than me second word length? 
            //  shorter one is the first word, if not, shorter one is the second word."
            int lengthOfShorterWord = words[i].length() < words[i+1].length() ? words[i].length() : words[i+1].length();
            
            for(int idx = 0; idx < lengthOfShorterWord; idx++) {
                int letter1 = alienAlphabet.get(words[i].charAt(idx));
                int letter2 = alienAlphabet.get(words[i+1].charAt(idx));
                
                if(letter1 > letter2) {
                    return false;
                }
                else if(letter1 < letter2) {
                    continue wordSearch;
                }
            }
            
            // Handle the case if we get through and the words were the same, but the first was actually longer.
            // "wordup" ... "word"
            // Would pass the above check, as good, but it is false.
            if(words[i].length() > words[i+1].length()) {
                return false;
            }
        }
        
        return true;
    }
    
}
