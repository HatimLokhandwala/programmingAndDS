package Arrays;
import javafx.util.Pair;
import java.util.Arrays;
public class GetMaxTasks {

    static int sort(int[] a, int[] b) {
        Pair<Integer, Integer> arr[] = new Pair[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = new Pair<>(a[i], b[i]);
        }
        Arrays.sort(arr, (p1 , p2) -> {
            if (p1.getValue() == p2.getValue()) {
                return p2.getKey() - p1.getKey();
            }
            return p1.getValue() - p2.getValue();
        });
        int tasks = 1;
        int endTime = arr[0].getValue();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getKey() > endTime) {
                tasks++;
                endTime = arr[i].getValue();
            }
        }
        return tasks;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 0, 5, 8, 5};
        int b[] = {2, 4, 6, 7, 9, 9};

        System.out.println(sort(a, b));
    }
}
