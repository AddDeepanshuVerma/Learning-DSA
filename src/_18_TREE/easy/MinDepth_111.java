package _18_TREE.easy;

class MinDepth_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }

    //================================================================

    public int minDepth2(TreeNode root) {
        if (root.left == null && root.right == null) return 1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) left = minDepth2(root.left);
        if (root.right != null) right = minDepth2(root.right);

        return Math.min(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}