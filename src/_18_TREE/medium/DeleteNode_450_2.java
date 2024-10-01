package _18_TREE.medium;

class DeleteNode_450_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val < val) root.right = deleteNode(root.right, val);
        else if (root.val > val) root.left = deleteNode(root.left, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.val = successor(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode successor(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

}