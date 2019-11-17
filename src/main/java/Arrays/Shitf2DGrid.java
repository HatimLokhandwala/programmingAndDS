package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D grid of size n * m and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 *     Element at grid[i][j] becomes at grid[i][j + 1].
 *     Element at grid[i][m - 1] becomes at grid[i + 1][0].
 *     Element at grid[n - 1][m - 1] becomes at grid[0][0].
 */

public class Shitf2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int prod = m * n;
        k = k % prod;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = (i * m + j);
                index = (index + k) % prod;
                int nRow = index / m;
                int nCol = index % m;

                res[nRow][nCol] = grid[i][j];
            }
        }
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(res[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5},
        };
        shiftGrid(grid, 23);
    }
}