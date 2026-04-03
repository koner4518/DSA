import java.util.*;

/*
 * Time Complexity:
 *   get() -> O(1)
 *   put() -> O(1)
 *
 * Space Complexity: O(capacity)
 *
 * Uses:
 * - HashMap for O(1) access
 * - Doubly Linked List to maintain LRU order
 */

class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = next = null;
    }
}

class LRUCache {

    private final Node head; // dummy head
    private final Node tail; // dummy tail

    private final HashMap<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // If key not present
        if (!map.containsKey(key))
            return -1;

        Node currNode = map.get(key);

        // Move accessed node to front (MRU)
        remove(currNode);
        insertAtFront(currNode);

        return currNode.val;
    }

    public void put(int key, int value) {

        // If key already exists → update and move to front
        if (map.containsKey(key)) {

            Node currNode = map.get(key);
            currNode.val = value;

            remove(currNode);
            insertAtFront(currNode);

        } else {

            // If capacity full → remove LRU node
            if (map.size() == capacity) {

                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }

            // Insert new node at front
            Node newNode = new Node(key, value);

            insertAtFront(newNode);
            map.put(key, newNode);
        }
    }

    // Insert node right after head (MRU position)
    private void insertAtFront(Node newNode) {

        newNode.next = head.next;
        newNode.prev = head;

        head.next.prev = newNode;
        head.next = newNode;
    }

    // Remove node from DLL
    private void remove(Node oldNode) {

        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
    }
}