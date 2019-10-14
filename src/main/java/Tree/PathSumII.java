package Tree;

import java.util.ArrayList;
import java.util.List;
// given a sum and a tree, determine all paths from root to any of the leafs
//which sums up to the given sum
public class PathSumII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return listOfLists;
        }
        int index = 0;
        traverse(root, 0, sum, listOfLists, list, index);
        System.out.println(list.size());
        return listOfLists;
    }

    void traverse(TreeNode root, int currentSum,
                  int reqSum, List<List<Integer>> lists,
                  List<Integer> list, int index) {
        if(root == null) {
            return;
        }
        currentSum += root.val;
        if(root.left == null && root.right == null) {
            if(currentSum == reqSum) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(root.val);
                lists.add(newList);
            }
            return;
        }
        list.add(root.val);
        traverse(root.left, currentSum, reqSum, lists, list, index + 1);
        traverse(root.right, currentSum, reqSum, lists, list, index + 1);
        list.remove(list.size() -1);

    }

}
