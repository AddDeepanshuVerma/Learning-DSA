package _18_TREE.algo;

class _44_RecoverTree_99_2 {
    TreeNode first, mid, last;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        /*
         * we need to fill three pointer first mid and last
         * how to fill : as soon as we find a val which is less than previous value
         * we mark it as first and again if we find another value which is less than previous one
         * we mark it mid and similar for last
         *
         * Now out of first mid and last
         * if last is null, switch values bw first & mid
         * else switch bw first and last :: as we are sure there has to be switched bw any of two.
         *  */
        inOrder(root);

        if (last == null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        } else {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        if (prev != null && root.val < prev.val) makeChanges(root, prev);
        prev = root;
        inOrder(root.right);
    }

    private void makeChanges(TreeNode root, TreeNode prev) {
        if (first == null) {
            first = prev;
            mid = root;
        } else {
            last = root;
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