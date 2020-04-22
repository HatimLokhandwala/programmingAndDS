/* *****************************************************************************
 *  Name: Hatim Lokhandwala
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private short[][] grid;
    private int openCount;
    private final int size;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final int topIndex;
    private final int bottomIndex;
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Value of n must be greater than 0");
        }
        openCount = 0;
        size = n;
        grid = new short[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        topIndex = n * n;
        bottomIndex = n * n + 1;
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n  + 2);
    }

    private void validRowColumn(int row, int col) {
        if (row < 1 || row > size) {
            throw new IllegalArgumentException("Row value must be between 1 and " +  size);
        }
        if (col < 1 || col > size) {
            throw new IllegalArgumentException("Column value must be between 1 and " +  size);
        }
    }


    private boolean validateIsOpen(int row, int col) {
        if (row < 1 || row > size) {
            return false;
        }
        if (col < 1 || col > size) {
            return false;
        }
        return isOpen(row, col);
    }
    /**
     *
     * @param row row number of the cell to be made open
     * @param col col number of the cell to be made open
     */
    public void open(int row, int col) {
        validRowColumn(row, col);
        if (isOpen(row, col)) {
            return;
        }
        openCount++;
        grid[row - 1][col - 1] = 0;
        int currentCell = ((row - 1) * size) + col -  1;
        if (validateIsOpen(row - 1, col)) {
            weightedQuickUnionUF.union(currentCell, (row - 2) * size + col - 1);
        }
        if (validateIsOpen(row + 1, col)) {
            weightedQuickUnionUF.union(currentCell, (row) * size + col - 1);
        }
        if (validateIsOpen(row, col - 1)) {
            weightedQuickUnionUF.union(currentCell, (row - 1) * size + col - 2);
        }
        if (validateIsOpen(row, col + 1)) {
            weightedQuickUnionUF.union(currentCell, (row - 1) * size + col);
        }
        if (row == 1) {
            weightedQuickUnionUF.union(currentCell, topIndex);
        }
        if (row == size) {
            weightedQuickUnionUF.union(currentCell, bottomIndex);
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return true if the cell corresponding to row, col is open
     */
    public boolean isOpen(int row, int col) {
        validRowColumn(row, col);
        return grid[row - 1][col - 1] == 0;
    }

    public boolean isFull(int row, int col) {
        validRowColumn(row, col);
        // if (row == size) {
        //     if (col - 1 > 0 && !isOpen(row, col - 1)) {
        //        return false;
        //     }
        //     if (col + 1 < size && !isOpen(row, col + 1)) {
        //         return false;
        //     }
        // }
        return weightedQuickUnionUF.connected(topIndex, (row - 1) * size + col - 1);
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(topIndex, bottomIndex);
    }

    public static void main(String[] args) {
        // empty method body
    }
}
