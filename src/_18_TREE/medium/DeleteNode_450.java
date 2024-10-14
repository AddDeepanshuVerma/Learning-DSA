package _18_TREE.medium;

class DeleteNode_450 {
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

        if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else {
            //case 1 : this root has no child
            if (root.left == null && root.right == null) return null;

            //case 2 : this root has one child left/right
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3 : this root has both child
            TreeNode LMS = getLMSuccessor(root.right);
            root.val = LMS.val;
            root.right = deleteNode(root.right, LMS.val); // update the right tree of curr root.
        }
        return root;
    }

    private TreeNode getLMSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}