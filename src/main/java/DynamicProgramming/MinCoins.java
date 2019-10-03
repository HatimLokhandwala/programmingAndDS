package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 12/05/19.
 */
public class MinCoins {
	static int minCoins(int arr[], int value){
		if(value == 0 ) {return 0;}
		int minValue = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(value-arr[i]>=0){
				minValue = Math.min(minValue, 1 + minCoins(arr, value-arr[i]));
			}
		}
		return minValue;
	}

	private static int minCoinsDp(int arr[], int value){
		int minValue[] = new int[value+1];
		minValue[0] = 0;
		for(int i=1;i<=value;i++){
			int minValueForIndex = Integer.MAX_VALUE;
			for (int anArr : arr) {
				if (i - anArr >= 0) {
					minValueForIndex = Math.min(minValueForIndex, 1 + minValue[i - anArr]); //Math.min(minValueForIndex,i-arr[j]);
				}
			}
			if(minValueForIndex==Integer.MAX_VALUE) minValueForIndex = 0;
			minValue[i] = minValueForIndex;
		}
		return minValue[value];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value = sc.nextInt();
		int arr[]  = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(minCoinsDp(arr, value));
	}
}



//n  = n-arr[i]