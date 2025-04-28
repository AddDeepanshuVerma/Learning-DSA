package _18_TREE.algo;

class _37_KthLargest {
    int count;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        val = -1;
        inOrder(root, k);
        return val;
    }

    // Right -> root -> Left : reverse InOrder
    private void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.right, k);
        if (++count == k) {
            val = root.val;
            return;
        }
        inOrder(root.left, k);
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