class reverseOnlyLettersStr {    
    public String reverseOnlyLetters(String S) {
        // Walk through the string, for each letter, put it in a stack.
        // Each non letter, put in a queue, and a "0" in the stack.
        // Pop through the stack, building a string, once we come 
        // across a "0", we poll() the queue for the correct non letter.
        
        if(S.length() == 0) return "";
        ArrayDeque<Integer> qIdx =  new ArrayDeque<Integer>();
        ArrayDeque<Character> q =  new ArrayDeque<Character>();
        ArrayDeque<Character> stack =  new ArrayDeque<Character>();
        
        int index = 0;
        for(char c : S.toCharArray()) {
            if(Character.isLetter(c)) {
                System.out.println("yo " + c);
                stack.push(c);
            }
            else {
                qIdx.offer(index);
                q.offer(c);
                // Push a non letter onto the stack
            }
            index++;
        }
        
        String newString = "";
        int idxForNonLetter = -9;
        
        if(!qIdx.isEmpty())
            idxForNonLetter = qIdx.poll();
        
        for(int i = 0; i < index; i++) {
            if(i == idxForNonLetter) {
                newString = newString + q.poll();
                if(!qIdx.isEmpty()) idxForNonLetter = qIdx.poll();
            }
            else {
                newString = newString + stack.pop();
            }
            System.out.println(newString);
        }
        
        System.out.println(newString);
        return newString;
    }
}
