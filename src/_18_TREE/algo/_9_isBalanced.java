package _18_TREE.algo;

public class _9_isBalanced {

    public static class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode(TreeNode left) {
            this.left = left;
        }
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

}
