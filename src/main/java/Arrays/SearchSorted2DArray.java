package Arrays;

/**
 * Given a 2d array sorted row wise and column wise
 * search for a given element
 */
public class SearchSorted2DArray {
    static boolean search(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }
        int row = arr.length - 1;
        int col = 0;
        int maxCol = arr[0].length;
        while (row >= 0 && col < maxCol) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        System.out.println(search(mat, 30));
        System.out.println(search(mat, 1));
        System.out.println(search(mat, 37));
    }

}
