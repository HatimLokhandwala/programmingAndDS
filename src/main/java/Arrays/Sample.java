package Arrays;

import java.util.*;

/**
 * Created by hatim.lokhandwala on 30/05/19.
 */

class Solution{
//	class Pair{
//		int x;
//		int y;
//		Pair(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
//
//	public  int[][] merge(int[][] intervals) {
//		if(intervals.length == 0) return new int[0][0];
//		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
////		for (int i=1; i<intervals.length; i++){
////			int j = i - 1;
////			int xCoord = intervals[i][0];
////			int yCoord = intervals[i][1];
////			while(j >= 0 && intervals[j][0] > xCoord) {
////				intervals[j + 1][0] = intervals[j][0];
////				intervals[j + 1][1] = intervals[j][1];
////				j--;
////			}
////			intervals[j + 1][0] = xCoord;
////			intervals[j + 1][1] = yCoord;
////		}
////		return new int[]{3,4};
//		for (int i=0; i<intervals.length; i++){
//			System.out.println(intervals[i][0] + " "  + intervals[i][1]);
//		}
//
//		List<Pair> list = new ArrayList<Pair>();
//		list.add(new Pair(intervals[0][0], intervals[0][1]));
//		for (int i=1; i<intervals.length; i++){
//			Pair p = list.get(list.size()-1);
//			if(intervals[i][0]<=p.y) {
//				p.y = Math.max (intervals[i][1], p.y);
//				// list.add(list.size()-1 , p);
//			} else {
//				list.add(new Pair(intervals[i][0], intervals[i][1]));
//			}
//		}
//
//		int[][] output  = new int[list.size()][2];
//		Iterator it = list.iterator();
//		while(it.hasNext()){
//			Pair p = (Pair)it.next();
//			System.out.println(p.x + " " + p.y);
//
//		}
//
////		Arrays.copyOfRange()
//		int j=0;
//		while(it.hasNext()){
//			Pair p = (Pair)it.next();
//			output[j][0] = p.x;
//			output[j][1] = p.y;
//			j++;
//		}
//		return output;
//	}
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int carry = 0;
		for(int i = A.size() - 1; i >= 0; i--) {
			Integer val = A.get(i);
//			A.remove
//			Integer sum = val + carry;
//			if(i == A.size() - 1) {
//				sum += 1;
//			}
//			val = sum % 10;
//			val.g
//			A.to
			String s = ("jhvhj");
			Integer[] arr = null;
			A.toArray(arr);
			System.out.println(val);
//			A.remove
//			A.add(i, val);
//			carry = sum / 10;
		}
		if(carry != 0) {
			A.add(0, carry);
		}
//		A.set()
//		A.toArray()
//				Arrays.
		return A;
	}

	void printList(ArrayList<Integer> A){
		System.out.println("--------------------------");
		Iterator it = A.iterator();
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			System.out.println(i);
		}
	}
}
public class Sample {


	public static void main(String[] args) {
		Solution s= new Solution();
		ArrayList<Integer> list = new ArrayList<>();

		list.add(2);
		list.add(9);
		s.printList(list);
		s.plusOne(list);
		s.printList(list);
//		int[][]  intervals = {{4,5}, {1,4}, {0,1}};
//		s.merge(intervals);

	}

}
