class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // clarifying / base cases / assumptions:
        // is the empty list possible?
        // what are the bounds of word sizes?
        // are non letters possible?
        // handle base case of just one word.
        List<List<String>> list = new ArrayList<>();
        
        // base case for one word.
        if(strs.length == 1) {
            List<String> l = new ArrayList<>();
            l.add(strs[0]);
            list.add(l);
            return list;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs) {
            Word word = new Word(s);
            
            if(map.containsKey(word.sortedName)) {
                // we could do this in one line, but for explaining purposes, use below.
                // map.get(word.sortedName).add(word.name);
                
                // retrieve our list
                List<String> wordsList = map.get(word.sortedName);
                
                // add the word.
                wordsList.add(word.name);
                
                // update map.
                map.put(word.sortedName, wordsList);
            }
            else {
                // since the sorted word doesn't exist, make new entry
                List<String> wordsList = new ArrayList<>();
                
                // add its word to the list.
                wordsList.add(word.name);
                
                // update map.
                map.put(word.sortedName, wordsList);
            }
        }
        
        // put each list of words in list.
        map.forEach((sortedName, wordsList) -> {
           list.add(wordsList);
        });
        
        return list;
    }
}

class Word {
    public String name;
    public String sortedName;
    
    Word(String n) {
        this.name = n;
        this.sortedName = sortName(n);
    }
    
    private String sortName(String n) {
        // handle the empty string for sorting.
        if(n.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        // the priority queue automatically sorts characters, no need to make comparator.
        Queue<Character> pq = new PriorityQueue<>(n.length());
        
        for(int i = 0; i < n.length(); i++) {
            pq.offer(n.charAt(i));
        }
        
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}

// i did it again. 7/9/19.
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> list = new ArrayList<>();
//         HashMap<String, ArrayList<String>> map = new HashMap<>();
        
//         for(String s : strs) {
//             Word word = new Word(s);
            
//             // if the map has our sorted key in it, just add the word to it's value's list.
//             if(map.containsKey(word.sorted)) {
//                 ArrayList<String> temp = map.get(word.sorted);
//                 temp.add(word.text);
//                 map.put(word.sorted, temp);
//             }
//             // make one, and then add to it's value's list.
//             else {
//                 ArrayList<String> temp = new ArrayList<String>();
//                 temp.add(word.text);
//                 map.put(word.sorted, temp);
//             }
//         }
        
//         map.forEach((sortedKey, wordList) -> {
//             list.add(wordList);
//         });
        
//         return list;
//     }
    
//     class Word {
//         String text;
//         String sorted;
        
//         Word(String s) {
//             this.text = s;
//             this.sorted = sort(s);
//         }
        
//         public String sort(String s) {
//             PriorityQueue<Character> pq = new PriorityQueue<>();
//             for(char letter : s.toCharArray()) {
//                 pq.offer(letter);
//             }
            
//             StringBuilder sb = new StringBuilder();
            
//             while(!pq.isEmpty()) {
//                 sb.append(pq.poll());
//             }
            
//             return sb.toString();
//         }
//     }
// }