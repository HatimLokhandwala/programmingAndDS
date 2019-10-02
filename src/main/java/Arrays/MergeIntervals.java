package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 05/07/19.
 */

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

class Solution1 {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//		List<Interval> inputList = intervals;
		Collections.sort(intervals, (i1, i2) -> {
			return i1.start -i2.start;
		});
		ArrayList<Interval> output = new ArrayList<>();
		output.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++) {
			Interval last = output.get(output.size() - 1);
			Interval current = intervals.get(i);
			if(current.start > last.end) {
				output.add(current);
			} else{
				last.end = Math.max(last.end, current.end);
			}
		}
		return output;
	}
}


public class MergeIntervals {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
//		s.merge();
		String str;
	}
}
