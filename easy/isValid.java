class isValid {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        HashMap<Character, Character> dict = new HashMap<Character, Character>();

        // Initialize dictionary with our valid mappings.
        dict.put('{', '}');
        dict.put('(', ')');
        dict.put('[', ']');

        for(char current : s.toCharArray()) {
            if(dict.containsKey(current)) {
                stack.push(dict.get(current));
            }
            else {
                // Short circuit if the first char we see is a closing pair.
                if(stack.size() == 0 || stack.pop() != current) {
                    return false;
                }
            }
        }

        return stack.size() == 0 ;
    }
}
