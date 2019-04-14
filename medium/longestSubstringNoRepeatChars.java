class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        if(s.length() == 0) return 0;
        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                if(w1.len > w2.len) {
                    return -1;
                }
                return 1;
            }
        });
        
        // abcabc
        
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            
            // first character
            char firstChar = s.charAt(i);
            sb.append(firstChar);
            set.add(firstChar);
            
            for(int j = i+1; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if(set.contains(c)) {
                    Word w = new Word(sb.toString(), sb.length());
                    pq.add(w);
                    break;
                }
                else {
                    set.add(c);
                    sb.append(c);
                    
                    if(j == s.length()-1) {
                        Word w = new Word(sb.toString(), sb.length());
                        pq.add(w);
                        break;
                    }
                }
            }
        }
        
        return pq.poll().len;
    }
}

class Word {
    public String word;
    public int len;
    
    Word(String w, int l) {
        this.word = w;
        this.len = l;
    }
}
