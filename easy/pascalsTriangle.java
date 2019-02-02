class Solution {
    public List<Integer> getRow(int rowIndex) {
        // base cases
        List<Integer> list = new ArrayList<Integer>();
        
        if(rowIndex == 0) {
            list.add(1);
            return list;
        }
        else if(rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }
        
        // this is row 1
        list.add(1);
        list.add(1);
        
        for(int i = 1; i < rowIndex; i++) {
            List<Integer> list2 = list;
            list = new ArrayList<Integer>();
            
            // always add one on first
            list.add(1);
            
            for(int j = 0; j < list2.size()-1; j++) {
                int current = list2.get(j) + list2.get(j+1);
                list.add(current);
            }
            
            list.add(1);
        }
        
        
        return list;
        
    }
}
