package Arrays;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 06/05/19.
 */

class Heap{
	int arr[];
	private int size;
	int currentPos;
	//creates a heap of given size;
	Heap(int size){
		this.size = size;
		this.currentPos = 0;
		arr = new int[size];
	}

	int getMinElement(){
		return arr[0];
	}

	public void addElement(int elem) {
		if(currentPos < size){
			arr[currentPos++] = elem;
		}
		int heapRoot = getMinElement();
		if(heapRoot < elem){
			insertToHeap(elem);
		}
	}

	private void insertToHeap(int elem) {
		arr[0] = elem;
		heapify(0);
	}

	private void heapify(int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int minIndex = i;
		int minValue = arr[i];
		if(left<size && arr[left] < arr[i]){
			minIndex = left;
			minValue = arr[left];
		}
		if(right<size && arr[right] < minValue ){
			minIndex = right;
			minValue = arr[right];
		}

		int temp = arr[i];
		arr[i] = minValue;
		arr[minIndex] = temp;
		if(minIndex != i) heapify(minIndex);
	}

	void printKLargest(){
		for(int i=0;i< currentPos;i++){
			System.out.println(arr[i]);
		}
	}

}
public class KLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		getKLargest(arr, k);
	}

	private static void getKLargest(int[] arr, int k) {
		Heap heap = new Heap(k);
		for(int elem: arr){
			heap.addElement(elem);
		}
		heap.printKLargest();
	}
}
