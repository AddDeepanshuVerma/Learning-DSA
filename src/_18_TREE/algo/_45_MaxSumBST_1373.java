package _18_TREE.algo;

class _45_MaxSumBST_1373 {
    int max;

    public int maxSumBST(TreeNode root) {
        /*
         * for each root available in our Tree check if that is a BST
         * if yes then calculate that root's sum and store it in a variable maintaining max value stored ever
         * that's our answer */
        max = 0;
        customTraverse(root);
        return max;
    }

    private void customTraverse(TreeNode root) {
        if (root == null) return;

        if (checkIfBST(root, null, null)) {
            max = Math.max(max, sumOfNodes(root));
        }
        customTraverse(root.left);
        customTraverse(root.right);
    }

    private boolean checkIfBST(TreeNode root, TreeNode minVal, TreeNode maxVal) {
        if (root == null) return true;

        if (minVal != null && root.val <= minVal.val) return false;
        if (maxVal != null && root.val >= maxVal.val) return false;

        return checkIfBST(root.left, minVal, root) && checkIfBST(root.right, root, maxVal);
    }

    private int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.val;
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