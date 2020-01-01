package misc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Compute the moving average of a stream of integers within a given window size.
 * MovingAverage object will be instantiated and called as such:
 *   MovingAverage obj = new MovingAverage(size);
 *   double param_1 = obj.next(val);
 */
public class MovingAverage {
    Deque<Integer> deque;
    int size;
    double sum = 0.0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deque = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if (deque.size() == size) {
            double first = deque.pollFirst();
            sum -= first;
        }
        deque.add(val);
        sum += val;
        return (double) sum / deque.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(6));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(15));
    }

}
