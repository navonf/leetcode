class MyLinkedList {
    public Node head;
    public int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int currIdx = 0;
        
        Node iter = this.head;
        while(iter != null) {
            if(currIdx == index) {
                return iter.val;
            }
            iter = iter.next;
            currIdx++;
        }
        
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(this.head == null) {
            this.head = new Node(val, null);
            this.size++;
            return;
        }
        
        // create the new node, and point it to next, since it comes before the first element.
        Node newNode = new Node(val, head);
        head = newNode;
        this.size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head == null) {
            this.head = new Node(val, null);
            this.size++;
            return;
        }
        
        Node iter = this.head;
        while(iter.next != null) {
            iter = iter.next;
        }
        // points to null because it is the last element in the linked lsit.
        iter.next = new Node(val, null);
        this.size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        
        if(index <= 0) {
            addAtHead(val);
            return;
        }
        
        // we already took care if 0 index case.
        int currIdx = 1;
        Node prev = this.head;
        Node iter = prev.next;
        Node newNode = new Node(val, null);
        
        while(iter != null) {
            if(currIdx == index) {
                this.size++;
                prev.next = newNode;
                newNode.next = iter;
                break;
            }
            prev = prev.next;
            iter = iter.next;
            currIdx++;
        }
        
        // if index is not a node, but the null pointer (end)
        if(currIdx == index) {
            prev.next = newNode;
            newNode.next = iter;
            this.size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > size-1) {
            return;
        }
        
        if(this.head == null) {
            return;
        }
        
        if(index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        
        Node prev = this.head;
        Node iter = prev.next;
        int currIdx = 1;
        
        while(iter != null) {
            if(currIdx == index) {
                this.size--;
                prev.next = iter.next;
                break;
            }
            prev = prev.next;
            iter = iter.next;
            currIdx++;
        }
    }
}

class Node {
    public int val;
    public Node next;
    
    public Node(int v, Node n) {
        this.val  = v;
        this.next = n;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
