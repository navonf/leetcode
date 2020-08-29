class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Word> pq = new PriorityQueue<>(
            words.length, 
            new Comparator<Word>() {
                @Override
                public int compare(Word w1, Word w2) {
                    if (w2.freq == w1.freq) {
                        return w1.content.compareTo(w2.content);
                    }
                    
                    return Integer.compare(w2.freq, w1.freq);
                }
            }
        );
        List<String> topK = new LinkedList<>();
        
        for (String word : words) {
            if (map.containsKey(word)) {
                int freq = map.get(word);
                map.put(word, ++freq);
            }
            else {
                map.put(word, 1);
            }
        }
        
        map.forEach((word, freq) -> {
            pq.offer(new Word(word, freq));
        });
        
        for (int i = 0; i < k; i++) {
            topK.add(pq.poll().content);
        }
        
        return topK;
    }
}

class Word {
    public String content;
    public int freq;
    
    public Word(String w, int f) {
        this.content = w;
        this.freq = f;
    }
}
