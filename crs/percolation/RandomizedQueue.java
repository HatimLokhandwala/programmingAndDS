/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Object[] arr;
    public RandomizedQueue() {
        size = 0;
        arr = new Object[1];
    }

    /**
     * checks if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the number of items in the randomized queue
     */
    public int size() {
       return  size;
    }

    private void resize() {
        Object[] newArr = new Object[2 * arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    /**
     * Adds given item in the queue
     * @param item to be added
     */
    public void enqueue(Item item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size == arr.length) {
            resize();
        }
        arr[size++] = item;
    }

    /**
     * removes and return a random item
     */
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = StdRandom.uniform(size);
        Item data = (Item) arr[index];
        arr[index] = arr[--size];
        return data;
    }

    /**
     * @return returns random item (but do not remove it)
     */
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = StdRandom.uniform(size);
        return (Item) arr[index];
    }

    /**
     * @return return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new RandomIterator<>(arr, size);
    }

    private class RandomIterator<V> implements Iterator<V> {
        private final Object[] iterArr;
        private int index;
        RandomIterator(Object[] arr, int size) {
            index = 0;
            iterArr = new Object[size];
            System.arraycopy(arr, 0, iterArr, 0, size);
            StdRandom.shuffle(iterArr);
        }
        @Override
        public boolean hasNext() {
            return index != iterArr.length;
        }

        @Override
        public V next() {
            if (index == iterArr.length) {
                throw new NoSuchElementException("No more items");
            }
            V data = (V) iterArr[index];
            index++;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        System.out.println("Size: " + randomizedQueue.size());
        System.out.println("Random Sample: " + randomizedQueue.sample());
        System.out.println("Random Sample: " + randomizedQueue.sample());
        randomizedQueue.enqueue(4);
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(6);
        randomizedQueue.enqueue(7);
        System.out.println("Size: " + randomizedQueue.size());
        System.out.println("Randome Deque: " + randomizedQueue.dequeue());
        for (Integer integer : randomizedQueue) {
            System.out.println(integer);
        }

    }
}
