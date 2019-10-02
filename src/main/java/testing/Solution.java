package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hatim.lokhandwala on 15/06/19.
 */
class Solution {
	public int[][] highFive(int[][] items) {
		Map<Integer, ArrayList<Integer>> idMap = new HashMap<>();
		String s[] = {"sad"};

		for(int i=0;i < items.length; i++) {
			int id = items[i][0];
			int number = items[i][1];
//			idMap.con
			if(idMap.containsKey(id)){
				ArrayList<Integer> list = idMap.get(id);
//				Integer.M
				list.add(number);
			} else{
				ArrayList<Integer> list = new ArrayList();
				list.add(number);
				idMap.put(id, list);
			}
		}
		// for(Integer i : idMap.keySet()){
		//     ArrayList<Integer> list = idMap.get(i);
//		     Collections.sort(list, Collections.reverseOrder());
		// }
		int size = idMap.size();
		int output[][] = new int[size][2];
		int j = 0;
		for(Integer i : idMap.keySet()){
			ArrayList<Integer> list = idMap.get(i);
			Collections.sort(list, Collections.reverseOrder());
			int sum = 0;
			for(int k=0; k < 5; k++){
				sum += list.get(k);
			}
			output[j][0] = i;
			output[j][1] =  sum / 5;
		}
		return output;
	}
}
