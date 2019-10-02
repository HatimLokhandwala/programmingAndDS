package testing;

import java.util.*;

/**
 * Created by hatim.lokhandwala on 17/06/19.
 */
class Pair1{
	int label;
	int value;
	Pair1(int value, int label){
		this.value = value;
		this.label = label;
	}
}
public class PQueue {
	ArrayList<Integer> a;
	static Character c = 'A';
	static int count = 2;


	static PriorityQueue<Pair1> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
//	Queue<Pair1> queue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
//	String s = new String(new char[]{'a'});

	static char ch = '1';
	static char ch1 = '2';
	static String s1 = "" + ch + ch1;
	static String s = String.format("%c%c", ch, ch1);


	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(10);
		ArrayList<Integer> b = new ArrayList<>(a);


		String s1 = count + c.toString();

		Stack<Integer> st = new Stack<>();
		st.pop();
		st.push(12);
		System.out.println(s1);
		q.peek();
	}
}
