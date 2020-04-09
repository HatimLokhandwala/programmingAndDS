package misc;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a increasing sorted list of intervals and an interval to be removed (removalInterval)
 * Return the list after removing the removalInterval from the given list
 */

public class IntervalRemoval {
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        int rStart = toBeRemoved[0];
        int rEnd = toBeRemoved[1];
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if (rStart > end || rEnd < start) {
                add(start, end, listOfLists);
            } else if (start < rStart && rEnd < end) {
                add(start, rStart, listOfLists);
                add(rEnd, end, listOfLists);
            } else if (start < rStart) {
                add(start, rStart, listOfLists);
            } else if (rEnd < end) {
                add(rEnd, end, listOfLists);
            }
        }
        return listOfLists;
    }

    static void add(int v1, int v2, List<List<Integer>> listOfLists) {
        List<Integer> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        listOfLists.add(list);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 2},
                {3, 4},
                {5, 7}
        };
        int[] toBeRemoved = {1, 6};
        List<List<Integer>> list = removeInterval(arr, toBeRemoved);
        list.forEach(elem -> {
            System.out.println(elem.get(0) + " " + elem.get(1));
        });
    }


}
