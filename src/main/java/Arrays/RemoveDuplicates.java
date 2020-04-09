package Arrays;

public class RemoveDuplicates {
    void removeDuplicates(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                index++;
                arr[index] = arr[i];
            }
        }
    }

    int removeDuplicatesII(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int index = (arr[0] == arr[1] ? 1 : 0);
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                index++;
                arr[index] = arr[i];
                if (i + 1 < arr.length && arr[index] == arr[i + 1]) {
                    index++;
                    arr[index] = arr[i];
                    i++;
                }
            }
        }
        return index;
    }

static void dummy( ) {
    int A1[] = {1, 2, 3};
    int A2[] = {1, 2, 3};
    if (A1.equals(A2))
        System.out.println("Same");
    else
        System.out.println("Not same");
}
    int moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return j;
    }

    static void dummy1() {
        String str="FiRstpROgrAm";;
        String s=str;
        int a=31,b=a++;
        if (s=="FiRstproRAm")
            System.out.println(b--);
        else
            System.out.println(--b);
    }


    public static int adjacent (int[][] arr)  {
        int len = arr.length;
        int[] output = new int[len];
        int globalMax = -1;
        for (int i = 0; i < len; i++) {
            int max = Math.max(arr[i][0], arr[i][1]);
            if ((i - 2) >= 0) {
                max += output[i - 2];
            }
            output[i] = max;
            System.out.println(max);
            globalMax  = Math.max(globalMax, max);
        }
        return globalMax;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {74,37, 82,1},
                {66,36, 16,1}
        };
        adjacent(arr);
    }
}