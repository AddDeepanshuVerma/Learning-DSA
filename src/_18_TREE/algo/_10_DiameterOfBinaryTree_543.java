package _18_TREE.algo;

class _10_DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        solve(root, diameter);
        return diameter[0];
    }

    private int solve(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int leftH = solve(root.left, diameter);
        int rightH = solve(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftH + rightH);
        return 1 + Math.max(rightH, leftH);
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