package Tree;

import java.util.Stack;

public class FlattenTree {
//	/**
//	 * Definition for binary tree
//	 */

		static TreeNode head;
		static TreeNode current;
		static void preOrder(TreeNode a) {
			if(a == null) {
				return;
			}
//			System.out.println(a.val);
			TreeNode right = a.right;
			TreeNode left = a.left;
			current.right = a;
			current = current.right;
			current.left = null;
			preOrder(left);
			preOrder(right);

		}
		public static TreeNode flatten(TreeNode a) {
			if(a == null){
				return null;
			}
			current = a;
			head = a;

			TreeNode right = a.right;
			preOrder(a.left);
			preOrder(right);
			current.left = null;
			current.right = null;
			return head;
		}

	public static void main(String[] args) {

		TreeNode one = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		one.left = second;
		one.right= third;
		flatten(one);
		while(head != null) {
			System.out.println(head.val);
			head = head.right;
		}
	}

}
