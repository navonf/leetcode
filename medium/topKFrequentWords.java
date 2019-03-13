class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Word> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>() {
            // the compare method returns an positive or negative integer based on
            // these 2 elements. return 1 means the current order is bad, swap. return -1
            // mean the current order is good, dont swap. if its equal to each other, usually
            // return 0 but in our case we will then sort by lex order using String.compareTo().
            @Override
            public int compare(Word w1, Word w2) {
                // ** w1 freq greater than w2 freq, keep the order. **
                // given some order of element 1, and element 2,
                // if the value of element 1 is greater than element 2, return a -1
                // which is a negative integer less than 0, don't swap! because this
                // is what we want, the higher frequency to be at the front of our PQ.
                if(w1.freq > w2.freq) {
                    return -1;
                }
                // ** w1 freq lesser than w2 freq, swap the order. **
                // given some order of element 1, and element 2,
                // if the value of element 1 is lesser than element 2, return a 1
                // which is a positive integer greater than 0, to swap them. because
                // we want to put the one with a higher frequency.
                else if(w1.freq < w2.freq) {
                    return 1;
                }
                // ** Strings are equal freq, return lexicographic order. **
                else {
                    int w1ComapredToW2 = w1.name.compareTo(w2.name);
                    if(w1ComapredToW2 <= 0) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            }
        });
        
        // cache in map.
        for(String w : words) {
            if(map.containsKey(w)) {
                Word word = map.get(w);
                word.freq++;
                map.put(w, word);
            }
            else {
                map.put(w, new Word(w));
            }
        }
        
        // load into pq.
        map.forEach((name, word) -> {
           pq.offer(word); 
        });
        
        // empty for k elements.
        int i = 0;
        while(i < k) {
            Word word = pq.poll();
            list.add(word.name);
            i++;
        }
        
        return list;
    }
    
    
}

class Word {
    public String name;
    public int freq;
    
    Word(String n) {
        this.name = n;
        this.freq = 1;
    }
}
