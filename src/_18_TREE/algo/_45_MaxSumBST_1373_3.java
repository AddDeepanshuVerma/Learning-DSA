package _18_TREE.algo;

class _45_MaxSumBST_1373_3 {
    int sum;

    public int maxSumBST(TreeNode root) {
        sum = 0;
        TreeInfo treeInfo = customTraverse(root);
        return sum;
    }

    private TreeInfo customTraverse(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeInfo left = customTraverse(root.left);
        TreeInfo right = customTraverse(root.right);
        int currSum = left.sum + right.sum + root.val;
        if (root.val > left.max && root.val < right.min) {
            sum = Math.max(sum, currSum);
            return new TreeInfo(currSum, Math.min(root.val, left.min), Math.max(root.val, right.max));
        } else return new TreeInfo(currSum, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static class TreeInfo {
        int sum;
        int min;
        int max;

        public TreeInfo(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
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