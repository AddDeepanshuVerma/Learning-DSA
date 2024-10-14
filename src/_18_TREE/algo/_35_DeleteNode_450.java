package _18_TREE.algo;

class _35_DeleteNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // we found the value
            //0. if it is a leaf node simply return null, as we are removing this node (it will be covered in next cond'n)
            //1. this has only no child or single child then return null or available child respectably
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //2. this has both child then search for leftmost successor form right branch and put the in our root as it will be the next appropriate
            // element to put here
            TreeNode temp = root.right;
            while (temp.left != null) temp = temp.left;
            root.val = temp.val;
            // now delete this val from right branch as it has been updated on the root (it's next appropriate space)
            root.right = deleteNode(root.right, root.val);
        }
        return root;
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