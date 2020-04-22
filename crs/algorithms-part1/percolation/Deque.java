/* *****************************************************************************
 *  Name: Hatim Lokhandwala
 *  Date:
 *  Description: Implementation of doubly ended queue
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Deque<Item> implements Iterable<Item> {

    private class Node<V> {
        private final V data;
        private Node<V> next;
        private Node<V> prev;
        Node(V data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<Item> firstNode;
    private Node<Item> lastNode;
    private int size;
    /**
     * construct an empty deque
     */
    public Deque() {
        size = 0;
    }

    /**
     * Checks whether deque is empty, returns true on empty, false otherwise
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Returns the number of items in the queue
     */
    public int size() {
        return size;
    }

    /**
     * adds the give item to the front of the list
     * @param item input item to be added
     * @throws IllegalArgumentException when item is null
     */
    public void addFirst(Item item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        size++;
        Node<Item> newNode = new Node<>(item);
        if (Objects.isNull(firstNode)) {
            lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode.prev = newNode;
        }
        firstNode = newNode;
    }

    /**
     * adds the given item to the back of the list
     * @param item input item to be added
     * @throws IllegalArgumentException when item is null
     */
    public void addLast(Item item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        size++;
        Node<Item> newNode = new Node<>(item);
        if (Objects.isNull(lastNode)) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        lastNode = newNode;
    }

    /**
     * Removes and return the item from the front of the queue
     * @throws NoSuchElementException when list is empty
    */
    public Item removeFirst() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue does not contain first element");
        }
        Item data = firstNode.data;
        if (firstNode.equals(lastNode)) {
            firstNode = null;
            lastNode = null;
        } else {
            Node<Item> next = firstNode.next;
            next.prev = null;
            firstNode.next = null;
            firstNode = next;
        }
        size--;
        return data;
    }

    /**
     * Removes and return the item from the back of the queue
     * @throws NoSuchElementException when list is empty
     */
    public Item removeLast() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue does not contain last element");
        }
        Item data = lastNode.data;
        if (firstNode.equals(lastNode)) {
            firstNode = null;
            lastNode = null;
        } else {
            Node<Item> prev = lastNode.prev;
            prev.next = null;
            lastNode.prev = null;
            lastNode = prev;
        }
        size--;
        return data;
    }

    /**
     * returns an iterator over items in order from front to back
     */
    public Iterator<Item> iterator() {
        return new DequeIterator<>(firstNode);
    }

    private class DequeIterator<V> implements Iterator<V> {
        private Node<V> iter;
        DequeIterator(Node<V> head) {
            iter = head;
        }

        @Override
        public boolean hasNext() {
            return iter != null;
        }

        @Override
        public V next() {
            if (Objects.isNull(iter)) {
                throw new NoSuchElementException("No more items");
            }
            V data = iter.data;
            iter = iter.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();
        System.out.println("IsEmpty: "  + deque.isEmpty());
        deque.addFirst(3);
        System.out.println("IsEmpty: "  + deque.isEmpty());
        deque.addLast(4);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(5);
        deque.addFirst(0);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        System.out.println("Size: " + deque.size());
        System.out.println("First Element: " + deque.removeFirst());
        System.out.println("Last Element: " + deque.removeLast());
        System.out.println("Size: " + deque.size());
    }
}
