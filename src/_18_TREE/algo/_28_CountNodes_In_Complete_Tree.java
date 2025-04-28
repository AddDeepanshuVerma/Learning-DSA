package _18_TREE.algo;

class _28_CountNodes_In_Complete_Tree {

    // As it is a complete binary Tree, we need to use its property
    int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int rightHeight(TreeNode root) {
        int count = 1;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }

    private int leftHeight(TreeNode root) {
        int count = 1;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    // TC : O(N)
    int countNodes2(TreeNode root) {
        if (root == null) return 0;

        int leftBranchCount = countNodes2(root.left);
        int rightBranchCount = countNodes2(root.right);

        return leftBranchCount + rightBranchCount + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}