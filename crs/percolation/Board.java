/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Objects;

public class Board {
    private int[][] tiles;
    private int rowCount;
    private int colCount;
    /** create aboard from an n-by-n array of tiles,
     * where tiles[row][col] = tile at (row, col)
     * @param tiles
     */
    public Board(int[][] tiles) {
        if (Objects.isNull(tiles)) {
            throw new IllegalArgumentException("tiles cannot be null");
        }
        rowCount = tiles.length;
        colCount = tiles[0].length;
        this.tiles = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        }
    }

    /**
     * @return string representation of this board
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(rowCount)
              .append("\n");
        for (int i = 0; i < rowCount; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                row.append(tiles[i][j])
                    .append(" ");
            }
            output.append(row.substring(0, row.length() - 1))
                  .append("\n");
        }
        return output.substring(0, output.length() - 1);
    }

    /**
     * @return board dimension
     */

    public int dimension() {
        return rowCount;
    }

    public int hamming() {
        int hammingDistance = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (tiles[i][j] == 0) continue;
                if (tiles[i][j] != ((i * rowCount) + j + 1)) {
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public boolean isGoal() {
        return hamming() == 0;
    }

    public int manhattan() {
        return 0;
    }
        //
        // // sum of Manhattan distances between tiles and goal
        //
        //
        // // is this board the goal board?
        //
        //
        // // does this board equal y?
        // public boolean equals(Object y)
        //
        // // all neighboring boards
        // public Iterable<Board> neighbors()
        //
        // // a board that is obtained by exchanging any pair of tiles
        // public Board twin()
        //
    public static void main(String[] args) {
        int[][] tiles = {
                { 1, 2, 3 },
                { 4, 5, 0 },
                { 6, 7, 8 }
        };
        Board b = new Board(tiles);
        System.out.println(b.toString());
    }
}
