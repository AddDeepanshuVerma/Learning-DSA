package _18_TREE.medium;

class LongestUnivaluePath_687 {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int max = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.left.val == root.val) max = Math.max(max, left + 1);
        if (root.right != null && root.right.val == root.val) max = Math.max(max, right + 1);

        if (root.left != null && root.right != null && root.right.val == root.left.val && root.right.val == root.val) {
            res = Math.max(res, left + right + 2);
        }
        // System.out.println("max = " + max);
        res = Math.max(res, max);
        return max;
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