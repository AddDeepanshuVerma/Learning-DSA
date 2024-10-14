package _18_TREE.algo;

class _30_Flatten_114 {
    TreeNode prev;

    /*
    using observations where going right most of the node and 1 by 1 assigning values as per requirement
    Here traversal is RIGHT -> LEFT -> ROOT
    */
    public void flatten(TreeNode root) {
        prev = null;
        DFS(root);
    }

    private void DFS(TreeNode node) {
        if (node == null) return;

        DFS(node.right);
        DFS(node.left);

        node.right = prev;
        node.left = null;

        prev = node;
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