class Solution {
    public boolean isValid(String s) {
        if(s == "") {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        
        for(int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if(stack.size() > 0 && (bracket == ']' || bracket == ')' || bracket == '}')) {
                if(map.containsKey(stack.peek()) && bracket != map.get(stack.pop())) {
                    return false;
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.size() == 0;
    }
}
