class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<String>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i == s.length()-1 && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else if(s.charAt(i) == ' ' && sb.length() > 0) {
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else if(s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        
        int stackLen = stack.size();

        for(int i = 0; i < stackLen; i++) {
            if(i == stackLen - 1) {
                sb.append(stack.pop());
            }
            else {
                sb.append(stack.pop());
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
