/* Navon Francis, 9/26/18
 * Currently does not work for a duplicate letter in p.
 */
class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // List to store all starting indecies.
        ArrayList indecies = new ArrayList<Integer>();

        // Outer loop goes through the string s
        for(int i = 0; i < s.length() - p.length() + 1; i++) {
            // This is where I will store the string p,
            // marking a 1, for each index in the word.
            // We need a new array because we will edit
            // it, however, we still need it's orignal
            // contents to persist.
            int[] alphabet = new int[26];

            // Java inits all values to 0, so we just
            // mark the spots with the 1s.
            for(int k = 0; k < p.length(); k++) {
                int index = p.charAt(k) - 'a';
                alphabet[index] = 1;
            }


            // Inner loop goes through the string s
            // for the length of p, starting at i.
            for(int j = 0; j < p.length(); j++) {
                // This checks the spot of the character,
                // minus 'a', which gives the ascii index,
                // and checks if that location is a 1.
                if(alphabet[(s.charAt(i + j)) - 'a'] == 1) {
                   alphabet[(s.charAt(i + j)) - 'a'] = 0;
                }
                else {
                    // Just break, the curr character in s
                    // is not in the string of p, or it is
                    // repeated.
                    break;
                }
            }

            // Check alphabet array.
            boolean flag = true;
            for(int k = 0; k < alphabet.length; k++) {
                if(alphabet[k] == 1) {
                    flag = false;
                }
            }

            if(flag) {
                indecies.add(i);
            }
        }

        return indecies;
    }
}
