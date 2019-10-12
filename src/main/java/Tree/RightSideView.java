package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Generate right side view of a binary tree
public class RightSideView {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            list.add(q.peek().val);
            int size = q.size();
            for(int i=1; i<=size; i++) {
                TreeNode head = q.poll();
                //add right nodes first
                if(head.right != null) q.add(head.right);
                if(head.left != null) q.add(head.left);
            }

        }
        return list;
    }

}
