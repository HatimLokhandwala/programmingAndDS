package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 06/06/19.
 */
public class SubsetSum {


		public static List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> targetList = new ArrayList();
			List<Integer> list = new ArrayList();
			generateSets(candidates, target, 0, 0, list, targetList);
			return targetList;
		}

		static void generateSets(int[] candidates, int target, int index, int currentSum, List<Integer> list, List<List<Integer>> targetList) {
			if(currentSum == target) {
				targetList.add(new ArrayList(list));
				return;
			}
			if(index >= candidates.length || currentSum > target) {
				return;
			}
			list.add(candidates[index]);
			generateSets(candidates, target, index, currentSum + candidates[index], list, targetList);
			System.out.println(index + " " + currentSum );
			list.remove(list.indexOf(candidates[index]));


			generateSets(candidates, target, index + 1, currentSum, list, targetList);
		}

	public static void main(String[] args) {
			int[] candidates = {2,3,6,7};
			int target = 7;
			ArrayList<Integer> e = new ArrayList<>();
		LinkedList[] list = new LinkedList[100];
		list[0] = new LinkedList();


		combinationSum(candidates, target);
	}

}
