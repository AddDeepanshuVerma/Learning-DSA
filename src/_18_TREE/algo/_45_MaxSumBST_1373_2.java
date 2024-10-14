package _18_TREE.algo;

class _45_MaxSumBST_1373_2 {
    int sum;

    public int maxSumBST(TreeNode root) {
        /*
         * We need to check multiple things for a node which are
         * sum till that node, if that node is a BST, max value Of it's left tree, min value of it's right tree
         * Hence will crate a custom class with all 4 members
         * Now we will do any traversal which go through left->right then root and
         * does all the required calculation based on its children
         * */
        sum = 0;
        TreeInfo treeInfo = customTraverse(root);
        return sum;
    }

    private TreeInfo customTraverse(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeInfo left = customTraverse(root.left);
        TreeInfo right = customTraverse(root.right);
        int currSum = left.sum + right.sum + root.val;
        boolean currIsBST = false;
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            currIsBST = true;
            sum = Math.max(sum, currSum);
        }

        return new TreeInfo(currSum, currIsBST, Math.min(root.val, left.min), Math.max(root.val, right.max));
    }

    static class TreeInfo {
        int sum;
        boolean isBST;
        int min;
        int max;

        public TreeInfo(int sum, boolean isBST, int min, int max) {
            this.sum = sum;
            this.isBST = isBST;
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