class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new LinkedList<>();
        if(S.length() == 0) return list;
        
        char prev = S.charAt(0);
        int same = 1;
        int firstIdx = 0;
            
        for(int i = 1; i < S.length(); i++) {
            if(prev == S.charAt(i))
                same++;
            else {
                if(same >= 3) {
                    list.add(new LinkedList<Integer>(Arrays.asList(firstIdx , i-1)));
                }
                same = 1;
                firstIdx = i;
            }
            
            prev = S.charAt(i);
        }
        
        // check if the last sequence is greater or equal to 3
        if(same >= 3) {
            list.add(new LinkedList<Integer>(Arrays.asList(firstIdx , S.length()-1)));
        }
        
        return list;
    }
}
