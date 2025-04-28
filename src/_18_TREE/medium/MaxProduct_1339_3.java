package _18_TREE.medium;

class MaxProduct_1339_3 {
    long max, total;

    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        return (int) (max % (1e9 + 7));
    }

    private long dfs(TreeNode root) {
        if (root == null) return 0;
        long rootSum = dfs(root.left) + dfs(root.right) + root.val;
        max = Math.max(max, (total - rootSum) * rootSum);
        return rootSum;
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