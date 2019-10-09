package Tree;
//Given a tree, validate that it is a binary search tree
public class ValidateBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return validBST(root);
    }

    boolean validBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean res = validBST(root.left);
        if(!res) {
            return false;
        }
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        res = validBST(root.right);
        if(!res) {
            return false;
        }
        return true;
    }

}
