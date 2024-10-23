package _18_TREE.easy;

class HasPathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int curr, int targetSum) {
        if (root == null) {
            return false;
        }
        curr += root.val;
        if (root.left == null && root.right == null && curr == targetSum) {
            return true;
        }
        return dfs(root.left, curr, targetSum) || dfs(root.right, curr, targetSum);
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