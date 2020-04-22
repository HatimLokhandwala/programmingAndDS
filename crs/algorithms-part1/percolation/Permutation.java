import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String val = StdIn.readString();
            randomizedQueue.enqueue(val);
        }
        Iterator<String> iterator = randomizedQueue.iterator();
        int count = 0;
        while (count < k) {
            System.out.println(iterator.next());
            count++;
        }
    }
}
