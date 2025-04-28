package _18_TREE.medium;

class MaxProduct_1339_2 {
    long max, sumOfTree;

    // return it modulo 10^9 + 7.
    public int maxProduct(TreeNode root) {
        max = 0;
        sumOfTree = getSum(root);
        dfs(root);
        return (int) (max % (1e9 + 7));
    }

    private long getSum(TreeNode root) {
        if (root == null) return 0;
        return getSum(root.left) + getSum(root.right) + root.val;
    }

    private long dfs(TreeNode root) {
        if (root == null) return 0;
        long rootSum = dfs(root.left) + dfs(root.right) + root.val;
        max = Math.max(max, (sumOfTree - rootSum) * rootSum);
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