package Tree;

public class InorderTraversal {
    static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }
}
