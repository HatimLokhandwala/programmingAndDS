package BFS;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;
  TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
public class RightSideView {
  List<Integer> getRightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> output = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      output.add(queue.peek().value);
      while (size > 0) {
        TreeNode headInQueue = queue.poll();
        if (headInQueue.right != null) {
          queue.add(headInQueue.right);
        }
        if (headInQueue.left != null) {
          queue.add(headInQueue.left);
        }
        size--;
      }
    }
    return output;
  }
//  new TreeNode(12, null, new TreeNode(13, null, null))

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10,
            new TreeNode(11, new TreeNode(12, null, new TreeNode(13, null, null)), null),
            new TreeNode(15, new TreeNode(18, null, null), null));
  }
}
