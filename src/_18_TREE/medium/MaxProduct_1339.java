package _18_TREE.medium;

class MaxProduct_1339 {
    long max;

    // return it modulo 10^9 + 7.
    public int maxProduct(TreeNode root) {
        max = 0;
        long sumOfTree = getSum(root);
        dfs(root, sumOfTree);

//        return (int) (max % 1000_000_007);
        return (int) (max % (1e9 + 7));
    }

    private long getSum(TreeNode root) {
        if (root == null) return 0;
        return getSum(root.left) + getSum(root.right) + root.val;
    }

    private long dfs(TreeNode root, long sumOfTree) {
        if (root == null) return 0;

        long left = dfs(root.left, sumOfTree);
        long right = dfs(root.right, sumOfTree);

        max = Math.max(max, (left + right + root.val) * (sumOfTree - (left + right + root.val)));
        max = Math.max(max, (sumOfTree - left) * left);
        max = Math.max(max, (sumOfTree - right) * right);

        return left + right + root.val;
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