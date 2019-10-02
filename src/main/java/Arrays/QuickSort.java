package Arrays;

/**
 * Created by hatim.lokhandwala on 20/07/19.
 */
public class QuickSort {
	static int partition(int[] arr, int left, int right) {
//		int pivotIndex = left;
		int pivot = arr[left];
		int index = left;
		for(int i = left + 1; i <= right; i++) {
			if(arr[i] <= pivot) {
				index++;
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[left];
		arr[left] = arr[index];
		arr[index] = temp;
		return index;
	}

//4 	2 3 6 7

	static void sort(int[] arr, int left, int right) {
		if(left <= right) {
			int index = partition(arr, left, right);
			sort(arr, left, index - 1);
			sort(arr, index + 1, right);
		}

	}
	public static void main(String[] args) {
		int[] arr = {2, 1, 34, 23, 60, 10};

		sort(arr, 0, arr.length - 1);
		for(int a: arr) {
			System.out.println(a);

		}

	}
}
