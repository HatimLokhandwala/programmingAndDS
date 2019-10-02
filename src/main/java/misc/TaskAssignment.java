package misc;

/**
 * Created by hatim.lokhandwala on 31/07/19.
 */

import java.util.*;
class TaskAssignment {
	static int countNumberOfIntervalsInCPU(char[] tasks, int n){
		if(tasks.length == 0) {
			return 0;
		}
		int[] count = new int[26];
		int runningCounter = 0;
		int totalTask = tasks.length;
		boolean flag = true;
		HashMap<Integer, Integer> hMap = new HashMap<>();
		for(int i=0; i<tasks.length; i++) {
			int index = tasks[i] - 'A';
			count[index]++;
		}

		while(totalTask > 0) {
			flag = true;
			for(int i = 0; i < count.length; i++) {
				if(count[i] != 0) {
					if(!hMap.containsKey(i) || runningCounter - hMap.get(i) >= n) {
						count[i]--;
						runningCounter++;
						flag = false;
						totalTask--;
//                                System.out.println(i + " RC: " + runningCounter);
						hMap.put(i, runningCounter);

					}
					if(totalTask <= 0) {
						break;
					}
				}

			}
			if(flag) {
				runningCounter++;
			}
			//                  System.out.println(" RC: " + runningCounter);
		}
		return runningCounter;
	}

	public static void main(String[] args) {
		char[] tasks =  {'A','A','A','B','B','B', 'C'};
		int n = 2;
		int intervals = countNumberOfIntervalsInCPU(tasks, n);
		System.out.println(intervals);

	}

}





