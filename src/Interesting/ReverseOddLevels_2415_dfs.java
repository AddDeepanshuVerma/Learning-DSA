package Interesting;

import jdk.jfr.Description;

class ReverseOddLevels_2415_dfs {
    public static TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    @Description("Correct and interesting approach")
    private static void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null || right == null) return;

        if ((depth & 1) == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }

    @Description("Initial approach which is wrong")
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;

        if ((level & 1) == 0 && root.left != null && root.right != null) {
            int temp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = temp;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}