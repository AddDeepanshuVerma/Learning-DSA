package _18_TREE.algo;

class _36_KthSmallest_230 {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inOrder(root, k);
        return result;
    }

    // Left -> root -> Right : InOrder
    private void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        if (++count == k) {
            result = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    private void inOrder2(TreeNode root, int k) {
        if (root == null) return;

        inOrder2(root.left, k);
        if (++count == k) {
            result = root.val;
        } else {
            inOrder2(root.right, k);
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