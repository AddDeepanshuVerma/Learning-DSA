package _18_TREE.easy;

class GetMinimumDifference_530 {
    int prev;
    int min;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        min = Math.min(Math.abs(prev - root.val), min);
        prev = root.val;
        inOrder(root.right);
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