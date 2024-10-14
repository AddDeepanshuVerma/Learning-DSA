package _18_TREE.algo;

class _38_IsValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;
        if (minNode != null && root.val <= minNode.val) return false;
        if (maxNode != null && root.val >= maxNode.val) return false;

        return dfs(root.left, minNode, root) && dfs(root.right, root, maxNode);
    }

    // ====================================================

    public boolean isValidBST2(TreeNode root) {
        return dfs2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs2(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;

        return dfs2(root.left, minValue, root.val) && dfs2(root.right, root.val, maxValue);
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