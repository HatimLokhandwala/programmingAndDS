package Tree;

public class EvaluateFullBinaryTree {
  //Problem details: You are given the root of a full binary tree with the following properties:
  //
  //    Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
  //    Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
  //
  //The evaluation of a node is as follows:
  //
  //    If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
  //    Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
  //
  //Return the boolean result of evaluating the root node.
  //
  //A full binary tree is a binary tree where each node has either 0 or 2 children.
  //
  //A leaf node is a node that has zero children.
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */

  public static boolean evaluateTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    return evaluateTreeUtil(root) == 1 ? true: false;
  }
  public static int evaluateTreeUtil(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val;
    }
    int left = evaluateTreeUtil(root.left);
    int right = evaluateTreeUtil(root.right);
    return root.val == 2 ? left | right : left & right;
  }

  public static void main(String[] args) {
    boolean answer1 = evaluateTree(new TreeNode(0));
    boolean answer2 = evaluateTree(new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3, new TreeNode(0), new TreeNode(1))));
    System.out.println(answer1);
    System.out.println(answer2);
  }

}
