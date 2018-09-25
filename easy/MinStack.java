/* Navon Francis, 9/25/18
 * This code runs in O(1) time complexity,
 * O(n) space complexity.
 */
class MinStack {
    ArrayList<Integer> data;
    ArrayList<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
        min.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        data.add(x);
        // Check the top of min, if it's bigger, add in the new min.
        if(min.get(min.size()-1) > x) {
            min.add(x);
        }
        // If the current min is smaller, just add that same min.
        else {
            min.add(min.get(min.size()-1));
        }
        // System.out.println(data);
    }

    public void pop() {
        // System.out.println("Before the pop" + data);
        // System.out.println("Index of the pop" + (data.size()-1));
        // Don't pop if ArrayList is empty!
        if(!data.isEmpty()) {
            // Remove the last thing in the list.
            // ex:
            // [1, 2, 3, ..nothing else..]
            // size = 3, data.remove(2);
            // [1, 2, ...nothing else..]
            data.remove(data.size()-1);
            min.remove(min.size()-1);
        }
        // System.out.println("After the pop " + data);
    }

    public int top() {
        // Return dat last ele.
        return data.get(data.size()-1);
    }

    public int getMin() {
        // System.out.println("GET MIN: " + data);
        return min.get(min.size()-1);
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
