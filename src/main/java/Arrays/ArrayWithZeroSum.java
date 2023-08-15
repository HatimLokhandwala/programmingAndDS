package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given an array of positive and negative numbers, find if there is a sub array (of size at least one) with 0 sum.
 eg:
 Sample Input: A[] = {4, 2, -3, 1, 6}
 Sample Output: Yes
 */
public class ArrayWithZeroSum {
    static boolean hasSubArrayWithZeroSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSumMap.containsKey(prefixSum)) {
                return true;
            }
            prefixSumMap.put(prefixSum, i);
        }
        return false;
    }

    public static void main(String args[]) {
        int[] arr = {4, 2, -2, 1, 6};
        System.out.println(hasSubArrayWithZeroSum(arr));
    }
}
