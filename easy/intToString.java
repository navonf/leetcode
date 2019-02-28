String intToString(int n) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean neg = false;
    
    if(n == 0) return "0";
    if(n < 0) neg = true;

    
    while(n > 0) {
        int peel = n % 10;
        stack.push(peel);
        n = n / 10;
    }

    if(neg) sb.append("-");

    while(!stack.isEmpty()) {
        int peeledNumAsciiVal = stack.pop() + 48;
        char c = (char)peeledNumAsciiVal;
        sb.append(c); 
    }

    return sb.toString();
}
