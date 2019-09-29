class PhoneDirectory {
    public Map<Integer, Node> map;
    public Node head;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.map = new HashMap<>();
        if(maxNumbers > 0) {
            this.head = new Node(0, null);
            map.put(head.val, head);
        }
        
        Node iter = this.head;
        for(int i = 1; i < maxNumbers; i++) {
            Node newNode = new Node(i, null);
            map.put(newNode.val, newNode);
            iter.next = newNode;
            iter = iter.next;
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(head == null) {
            return -1;
        }
        
        Node ret = this.head;
        // this next line may be null if its the last one
        this.head = this.head.next;
        this.map.remove(ret.val);
        
        return ret.val;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return this.map.containsKey(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(map.containsKey(number)) {
            return;
        }
        if(this.head == null) {
            // System.out.println("should be null, release 2: " + number);
            this.head = new Node(number, null);
            this.map.put(number, this.head);
            return;
        }
        
        Node newNode = new Node(number, this.head);
        this.head = newNode;
        
        this.map.put(number, newNode);
    }
}

class Node {
    public int val;
    public Node next;
    
    public Node(int v, Node n) {
        this.val = v;
        this.next = n;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
