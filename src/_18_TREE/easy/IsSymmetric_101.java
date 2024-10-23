package _18_TREE.easy;

class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return checkIfSymmetric(root.left, root.right);
    }

    private boolean checkIfSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        return left.val == right.val && checkIfSymmetric(left.left, right.right) && checkIfSymmetric(left.right, right.left);
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