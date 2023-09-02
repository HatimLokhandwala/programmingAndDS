package Arrays;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
 * (i.e The length of the garden is n).
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap
 * can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot
 * be watered return -1.
 */
public class MinimumTaps {

    public static int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            arr[left] = Math.max(arr[left], right);
        }
        int maxReachable = 0;
        int index = 0;
        int end = 0;
        int count = 0;
        while (end < n) {
            count++;
            while (index <= end) {
                maxReachable = Math.max(maxReachable, arr[index]);
                index++;
            }
            if (maxReachable == end) {
                return -1;
            }
            end = maxReachable;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,1,1,0,0 };
        System.out.println(minTaps(5, arr));
    }

}
