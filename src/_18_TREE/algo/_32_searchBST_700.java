package _18_TREE.algo;

class _32_searchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        return root.val < val ? searchBST2(root.right, val) : searchBST2(root.left, val);
    }

    public TreeNode searchBST3(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return searchBST3(root.val < val ? root.right : root.left, val);
    }

    public TreeNode searchBST4(TreeNode root, int val) {
        return (root == null || root.val == val) ? root : searchBST4(root.val < val ? root.right : root.left, val);
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