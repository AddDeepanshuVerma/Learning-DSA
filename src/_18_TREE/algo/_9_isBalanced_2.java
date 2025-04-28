package _18_TREE.algo;

public class _9_isBalanced_2 {

    public static class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode(TreeNode left) {
            this.left = left;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        if (leftHeight == -1 || rightHeight == -1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int height2(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height2(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height2(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
