class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> cache; // key node
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.left = new Node(0, 0); // left dummy node
        this.right = new Node(0, 0); // right dummy node
        left.next = right;
        right.prev = left;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        node.prev = prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
