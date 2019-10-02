package dp;

/**
 * Created by hatim.lokhandwala on 19/05/19.
 */
public class RodCutting {

	/* Returns the best obtainable price for a rod of length
		n and price[] as prices of different pieces */
		static int cutRod(int price[], int n) {
			int rodMax[] = new int[n+1];
			rodMax[0] =0;
			for(int i=1;i<=n;i++){
				int max = Integer.MIN_VALUE;

				for(int j=1;j<=i;j++){
					if(price[j-1] + rodMax[i-j] > max)
						max = rodMax[i-j] + price[j-1];
				}
				rodMax[i] = max;
			}
			return rodMax[n];
		}

		/* Driver program to test above functions */
		public static void main(String args[]) {
			int arr[] = new int[] {100, 5, 50};
			int size = arr.length;
			System.out.println("Maximum Obtainable Value is "+
					cutRod(arr, size));

		}
}


