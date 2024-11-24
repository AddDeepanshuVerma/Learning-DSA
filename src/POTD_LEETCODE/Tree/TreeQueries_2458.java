package POTD_LEETCODE.Tree;

// Getting TLE as inputs were : total nodes : 2 <= n <= 105 & queries length m : 1 <= m <= min(n, 104)
class TreeQueries_2458 {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = height(root, queries[i]);
        }

        return ans;
    }

    private int height(TreeNode root, int target) {
        if (root == null || root.val == target) return -1; // counting max edges

        return Math.max(height(root.left, target), height(root.right, target)) + 1;
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