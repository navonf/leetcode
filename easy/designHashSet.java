class MyHashSet {
    // hashset bucket
    // hashset range
    private Bucket[] set;
    private int bucketRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucketRange = 997;
        this.set = new Bucket[this.bucketRange];
        
        for (int i = 0; i < bucketRange; i++) {
            this.set[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int idx = this.hash(key);
        this.set[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = this.hash(key);
        this.set[idx].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = this.hash(key);
        return this.set[idx].contains(key);
    }
    
    // given the key, assign a hash function
    // using basic modulo
    private int hash(int key) {
        return key % bucketRange;
    }  
}

class Bucket {
    private LinkedList<Integer> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Integer>();
    }
    
    public void add(int key) {
        int index = this.bucket.indexOf(key);
        if (index == -1) {
          this.bucket.addFirst(key);
        }
    }
    
    public void remove(Integer key) {
        this.bucket.remove(key);
    }
    
    public boolean contains(Integer key) {
        return this.bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
