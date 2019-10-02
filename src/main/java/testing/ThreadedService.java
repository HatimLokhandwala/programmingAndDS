package testing;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hatim.lokhandwala on 25/06/19.
 */
public class ThreadedService {

	static ExecutorService ex;
	public static void main(String[] args) {
		ex = Executors.newFixedThreadPool(10);
		System.out.println(1<<2);
		int a = (3 << 5 );
		int a1 = (-1 << 5 );
		int cap = (1 << 5) - 1;
		System.out.println(a1);
		System.out.println(a);
		System.out.println(cap);
		System.out.println(a & ~cap);

		Stack<Integer> st = new Stack<>();
		List<Integer> list = new ArrayList<>(4);

		list.add(12);
		list.add(12123);

		int arr[] = new int[10];
		for(int i=0;i< 10;i++) {
			arr[i]  = i;
		}
		for(int i=0;i< 10;i++) {
			System.out.println(arr[i]);
		}
		int newArr[] = Arrays.copyOf(arr, 20);
		for(int i=0;i< 20;i++) {
			System.out.println(newArr[i]);
		}

	}
}
