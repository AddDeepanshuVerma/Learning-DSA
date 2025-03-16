package _21_Graphs.Leetcode._3hard;

class MaxPathSum_124 {

    private int maxSum;

     static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) left = dfs(root.left);
        if (root.right != null) right = dfs(root.right);

        int temp = Math.max(Math.max(left + root.val, right + root.val), root.val);
        maxSum = Math.max(maxSum, Math.max(temp, root.val + left + right));

        return temp;
    }
}