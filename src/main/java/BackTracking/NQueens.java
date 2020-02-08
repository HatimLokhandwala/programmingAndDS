package BackTracking;

import java.util.HashSet;
import java.util.Set;

class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] col = new int[n];
        Set<Integer> leftDiagonal = new HashSet<>();
        Set<Integer> rightDiagonal = new HashSet<>();
        traverse(0, n, col, leftDiagonal, rightDiagonal);
        return count;
    }
    boolean isSafe(int row, int column, int[] col, Set<Integer> leftDiagonal, Set<Integer> rightDiagonal) {
        if (col[column] == 1) {
            return false;
        }
        if (leftDiagonal.contains(row - column)) {
            return false;
        }
        return !rightDiagonal.contains(row + column);
    }
    void traverse(int index, int n, int[] col, Set<Integer> leftDiagonal, Set<Integer> rightDiagonal) {
        if (index >= n) {
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(index, j, col, leftDiagonal, rightDiagonal)) {
                col[j] = 1;
                leftDiagonal.add(index - j);
                rightDiagonal.add(index + j);
                if (index == n - 1) {
                    count++;
                }
                traverse(index + 1, n, col, leftDiagonal, rightDiagonal);
                col[j] = 0;
                leftDiagonal.remove(index - j);
                rightDiagonal.remove(index + j);
            }
        }
    }
}

class SolutionII {
    int count = 0;
    public int totalNQueens(int n) {
        int[] col = new int[n];
        int[] left = new int[2 * n];
        int[] right = new int[2 * n];
        traverse(0, n, col, left, right);
        return count;
    }
    boolean isSafe(int row, int column, int[] col, int[] left, int[] right) {
        if (col[column] == 1) {
            return false;
        }
        if (left[row - column + col.length] == 1) {
            return false;
        }
        if (right[row + column] == 1) {
            return false;
        }
        return true;
    }
    void traverse(int index, int n, int[] col, int[] left, int[] right) {
        if (index >= n) {
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(index, j, col, left, right)) {
                col[j] = 1;
                left[index - j + n] = 1;
                right[index + j] = 1;
                if (index == n - 1) {
                    count++;
                }
                traverse(index + 1, n, col, left, right);
                col[j] = 0;
                left[index - j + n] = 0;
                right[index + j] = 0;
            }
        }
    }
}
public class NQueens {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(5));
        SolutionII solution2 = new SolutionII();
        System.out.println(solution2.totalNQueens(5));
    }
}
