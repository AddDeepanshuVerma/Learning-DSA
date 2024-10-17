package _18_TREE.easy;

class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        return heightDiff(root) != -1;
    }

    private int heightDiff(TreeNode root) {
        if (root == null) return 0;

        int left = heightDiff(root.left);
        if (left == -1) return -1;

        int right = heightDiff(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
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