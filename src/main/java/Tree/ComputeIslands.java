package Tree;

import java.util.*;

/**
 * Created by hatim.lokhandwala on 01/07/19.
 */
public class ComputeIslands {

	static void  traverse(char[][] grid, int row, int column) {
			if(row < 0 || row >= grid.length) {
				return;
			}
			if(column < 0 || column >= grid[0].length) {
				return;
			}
			if(grid[row][column] == '1'){
				grid[row][column] = 'Y';
				traverse(grid, row + 1, column);
				traverse(grid, row, column + 1);
			}
		}
		public static int numIslands(char[][] grid) {
			int nIslands = 0;
			// if(grid.length == 0) {
			//     return nI;
			// }

			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[0].length; j++) {
					if(grid[i][j] == '1') {
						nIslands++;
						traverse(grid, i, j);
					}
				}
			}
			return nIslands;
		}
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
	}
}
