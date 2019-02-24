class MyStack {
    public Queue<Integer> q1;
    public Queue<Integer> q2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    // q1: 5, 4, 3, 2, 1
    // q2: 
    // MyStack: 5, 4, 3, 2, 1
    public void push(int x) {
        if(empty()) {
            q1.offer(x);
        }
        else if(q1.isEmpty() && !q2.isEmpty()) {
            q1.offer(x);
            while(!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }
        else if(q2.isEmpty() && !q1.isEmpty()) {
            q2.offer(x);
            while(!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int popMe = q1.isEmpty() ? q2.poll() : q1.poll();
        return popMe;
    }
    
    /** Get the top element. */
    public int top() {
        int peekMe = q1.isEmpty() ? q2.peek() : q1.peek();
        return peekMe;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
