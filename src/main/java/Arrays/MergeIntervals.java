package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

class Solution {
	public ArrayList<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
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
		Solution s = new Solution();
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1,5));
		list.add(new Interval(-1,20));
		list.add(new Interval(4,15));
		list.add(new Interval(100,150));
		list.add(new Interval(120,500));
		s.merge(list);
	}
}
