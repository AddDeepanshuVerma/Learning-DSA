package _18_TREE.algo;

class _41_FindPreSuc {
    public static void findPreSuc(TreeNode root, int key) {
        TreeNode pre = inorderPredecessor(root, key);
        TreeNode suc = inorderSuccessor(root, key);
    }

    public static TreeNode inorderPredecessor(TreeNode root, int x) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val < x) {
                ans = root;
                root = root.right;
            } else {                // even if we found the same node we search at its left branch
                root = root.left;
            }
        }
        return ans;
    }

    public static TreeNode inorderSuccessor(TreeNode root, int x) {
        //add code here.
        TreeNode ans = null;
        while (root != null) {
            if (root.val <= x) {    // even if we found the same node we search at its right branch
                root = root.right;
            } else {
                ans = root;
                root = root.left;
            }
        }
        return ans;
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