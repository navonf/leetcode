class Solution {
    public int[] sortArrayByParity(int[] A) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int size = A.length;
        for(int num : A) {
            if(num % 2 == 0) {
                deq.addFirst(num);
            }
            else {
                deq.addLast(num);
            }
        }
        
        int[] parity = new int[size];
        
        for(int i = 0; i < size; i++) {
            parity[i] = deq.poll();
        }
        
        return parity;
    }
}
