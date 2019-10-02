package dp;

import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 02/05/19.
 */
public class CoinChange {
	private static int nWaysForCoinChange(int sum, int coin[]){
		int waysDp[][] = new int[sum+1][coin.length];
		for(int i=0;i<=sum;i++){ waysDp[i][0] = 0;}
		for(int i=0;i<coin.length;i++){ waysDp[0][i] = 1;}

		for(int i=1;i<=sum;i++){
			for(int j=1;j<coin.length;j++){
				waysDp[i][j] = waysDp[i][j-1] + ((i-coin[j] >=0) ? waysDp[i-coin[j]][j] : 0);
			}
		}

		for(int i=0;i<=sum;i++){
			for(int j=0;j<coin.length;j++){
				System.out.print(waysDp[i][j] + " " );

			}
			System.out.println();
		}
		System.out.println("-----------------");
		return waysDp[sum][coin.length-1];
	}

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int sum = sc.nextInt();
		int arraySize = sc.nextInt();
		int coin[] = new int[arraySize+1];
		for(int i=1;i<=arraySize;i++){
			coin[i] = sc.nextInt();
		}
		System.out.println(nWaysForCoinChange(sum, coin));
	}
}

////
//0 0 0
//		1 1 1
//		0 1 1
//		1 1 1
//		0 1 2


//5 3 5 3 2
//--/
//		1 1 1 1
//		0 0 0 0
//		0 0 0 1
//		0 0 1 1
//		0 0 0 1
//		0 1 1 2

//		  2 3 5
//		1 1 1 1
//		0 0 0 0
//		0 1 1 1
//		0 0 1 1
//		0 1 1 1
//		0 0 1 2
