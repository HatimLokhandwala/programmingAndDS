package dp;

import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 12/05/19.
 */
public class GoldMine {
	private static int computeMaxGold(int n, int m, int goldArr[][]){
		//array that holds maximum amnt of gold reaching i,j
		int maxGoldTable[][] = new int[n][m];
		for(int row=0;row<n;row++){
			maxGoldTable[row][0] = goldArr[row][0];
		}

		for(int column=1;column<m;column++){
			for(int row=0;row<n;row++){
				int left_up = ((row-1) >=0 && (column-1)>=0 ) ? maxGoldTable[row-1][column-1]:0;
				int left = ( (column-1)>=0 ) ? maxGoldTable[row][column-1]:0;
				int left_down = ((row+1) <n && (column-1)>=0 ) ? maxGoldTable[row+1][column-1]:0;
				maxGoldTable[row][column] = goldArr[row][column] + Math.max(left_up, Math.max(left, left_down));
			}
		}
		int maxValue = Integer.MIN_VALUE;
		for(int row=0;row<n;row++){
			maxValue = Math.max(maxValue, maxGoldTable[row][m-1]);
		}
		return maxValue;
	}


	//	main class
	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int goldArr[][] = new int[n][m];
		for(int row = 0 ; row< n; row++){
			for(int column = 0; column < m;column++){
				goldArr[row][column]=sc.nextInt();
			}
		}
		System.out.println(computeMaxGold(n,m,goldArr));

	}
}
