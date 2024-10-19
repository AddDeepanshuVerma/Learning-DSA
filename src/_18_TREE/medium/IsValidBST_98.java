package _18_TREE.medium;

class IsValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if(root.val <= minValue || root.val >= maxValue) return false;

        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
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