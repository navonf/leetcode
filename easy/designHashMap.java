class MyHashMap {
    public int size;
    public LinkedList<Bucket> map;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.size = 2069;
        this.map = new LinkedList<Bucket>();
        
        for (int i = 0; i < size; i++) {
            this.map.add(i, new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = this.hash(key);
        Bucket b = this.map.get(idx);
        if (b != null) {
            b.insert(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = this.hash(key);
        Bucket b = this.map.get(idx);
        if (b != null) {
            Pair p = b.getPair(key);
            if (p != null) {
                return p.val;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = this.hash(key);
        Bucket b = this.map.get(idx);
        if (b != null) {
            b.delete(key);
        }
    }
    
    public int hash(int key) {
        return key % size;
    }
}

class Bucket {
    public LinkedList<Pair> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair>();
    }
    
    public Pair getPair(int key) {
        for (Pair p : this.bucket) {
            if (p.key == key) {
                return p;
            }
        }
        return null;
    }
    
    public void insert(int key, int val) {
        boolean hasKey = false;
        Pair p = this.getPair(key);
        
        // update
        if (p != null) {
            this.delete(key);
            
        }
        
        this.bucket.addFirst(new Pair(key, val));
    }
    
    public void delete(int key) {
        for (Pair p : this.bucket) {
            if (p.key == key) {
                this.bucket.remove(p);
                break;
            }
        }
    }
}

class Pair {
    public int key;
    public int val;
    
    public Pair(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
