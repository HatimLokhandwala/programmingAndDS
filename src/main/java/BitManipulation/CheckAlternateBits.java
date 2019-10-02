package BitManipulation;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hatim.lokhandwala on 04/07/19.
 */
class Solution{
	boolean checkAlternateBits(int n) {
		while(n > 0) {
			int bit1 = n & 1;
			int bit2 = (n & 2 ) >> 1;
			System.out.println(bit1 + " " + bit2);
			if((bit1 ^ bit2) == 0) {
				return false;
			}
			n = n >> 1;
		}
		return true;
	}
}
public class CheckAlternateBits {
	public static void main(String[] args) {
		Solution  s = new Solution();
		System.out.println(s.checkAlternateBits(10));
		Queue<Integer> q = new PriorityQueue<>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}



		});
		q.remove();
	}
}
