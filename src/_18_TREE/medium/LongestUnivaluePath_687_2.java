package _18_TREE.medium;

class LongestUnivaluePath_687_2 {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.left.val == root.val) left++;
        if (root.right != null && root.right.val == root.val) right++;

        res = Math.max(res, left + right);
        return Math.max(left, right);
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