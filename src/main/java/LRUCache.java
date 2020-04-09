import java.util.HashMap;
import java.util.Map;

/**
 * Created by hatim.lokhandwala on 23/02/20
 */

public class LRUCache {
        class Node {
            int key;
            int data;
            Node prev;
            Node next;
            Node(int key, int data) {
                this.data = data;
                this.key = key;
                prev = null;
                next = null;
            }
        }
        int capacity;
        Map<Integer, Node> cache;
        Node head;
        Node tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            head = null;
            tail = null;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            Node n = cache.get(key);
            removeNode(n);
            addNode(n);
            return n.data;
        }
        public void removeNode(Node n) {
            if(tail == n) {
                tail = n.prev;
            }
            if(head == n ) {
                head = n.next;
            }
            if(n.prev != null) {
                n.prev.next = n.next;
            }
            if(n.next != null) {
                n.next.prev = n.prev;
            }
            n.prev = null;
            n.next = null;
        }

        public void addNode(Node n) {
            n.next = head;
            if(head != null) {
                head.prev = n;
            }
            if(tail == null){
                tail = n;
            }
            head = n;
        }

        public void set(int key, int value) {
            if(cache.containsKey(key)){
                Node n = cache.get(key);
                n.data = value;
                removeNode(n);
                addNode(n);
            } else {
                if(cache.size()>=this.capacity){
                    cache.remove(tail.key);
                    removeNode(tail);
                    Node newNode = new Node(key, value);
                    addNode(newNode);
                    cache.put(key, newNode);
                } else {
                    Node newNode = new Node(key, value);
                    cache.put(key, newNode);
                    addNode(newNode);
                }
            }
        }


}
