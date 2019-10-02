package Arrays;

import java.util.*;

/**
 * Created by hatim.lokhandwala on 14/04/19.
 */
//find k closest element to a given element in an array
public class KClosest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases  = sc.nextInt();
		for(int count=1;count<=testCases;count++){
			int size = sc.nextInt();
			int searchNumber = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[size];
			for(int j=0;j<size;j++){
				a[j] = sc.nextInt();
			}
			process(a, searchNumber, k);
		}
	}

	private static void process(int[] a, int searchNumber, int k) {
		int result = binarySearch(a, 0, a.length-1 , searchNumber);
		List<Integer> resultList = new ArrayList<Integer>();
		int count=0;
		int left = result-1;
		int right =result+1;
		if(a[result] < searchNumber){
			left = result;
			right = result+1;
		}

		if(a[result]> searchNumber){
			left = result -1;
			right = result;
		}

		while(left>=0 && right<a.length && count<k){
			if(Math.abs(a[left] -searchNumber)< Math.abs(a[right]-searchNumber)){
				resultList.add(a[left--]);
			}
			else{
				resultList.add(a[right++]);
			}
			count++;
		}

		for(;left>=0 && count<k;left--){
			count++;
			resultList.add(a[left]);
		}
		for(;right<a.length && count<k;right++){
			count++;
			resultList.add(a[right]);
		}
		Collections.sort(resultList);
		for(Integer integer:resultList){
			System.out.print(integer  + " ");
		}
	}

	private static int binarySearch(int[] a, int start, int end, int searchNumber) {
		if(end<start) return -1;
		int mid = start  + (end-start + 1)/2;
		if(a[mid] == searchNumber) return mid;
		else if(a[mid]>searchNumber) {
			int ret = binarySearch(a, start, mid - 1, searchNumber);
			return ret == -1 ? mid : ret;
		}
		else {
			int ret = binarySearch(a, mid + 1, end, searchNumber);
			return ret == -1 ? mid : ret;
		}
	}
}
