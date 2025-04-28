package LeetCode_33Question_challenge_2025.week1;

public class Q11 {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs2(root);
        return maxSum;
    }

    private int dfs2(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) left = dfs2(root.left);
        if (root.right != null) right = dfs2(root.right);

        int temp = Math.max(Math.max(left + root.val, right + root.val), root.val);
        maxSum = Math.max(maxSum, Math.max(temp, root.val + left + right));

        return temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }
}
