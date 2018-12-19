class MinStack {
    public ArrayDeque<Integer> stack;
    public ArrayDeque<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        
        if(min.isEmpty()) {
            min.push(x);
        }
        // then compare in the minimum stack.
        else {
            if(min.peek() < x) {
                min.push(min.peek());
            }
            else {
                min.push(x);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
