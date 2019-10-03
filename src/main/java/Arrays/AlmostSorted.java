package Arrays;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hatim.lokhandwala on 02/07/19.
 * Given an array which is sorted just that two of the elements are swapped
 * Find the indices of those elements, which after swapping will make the entire array sorted again
 * eg:  i/p:  1 4 3 2 5
 * 		o/p:  [1,3]
 */

public class AlmostSorted {
	static int[] getIndices(int[] arr){
		int x = -1, y = -1;
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				y = arr[i + 1];
				if(x == -1) {
					x = arr[i];
				}
			}
		}
		int[] indices = {x, y};
		return indices;
	}
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4, 5, 6};
		int[] ret = getIndices(arr);
		for (int aRet : ret) {
			System.out.print(aRet + " ");
		}

	}
}


