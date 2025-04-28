package Interesting;

import java.util.BitSet;

class FindElements {
    BitSet set;

    public FindElements(TreeNode root) {
        root.val = 0;
        set = new BitSet();
        recoverTree(0, root);
    }

    public boolean find(int target) {
        return set.get(target);
    }

    private void recoverTree(int val, TreeNode root) {
        root.val = val;
        set.set(root.val);
        if (root.left != null) recoverTree((val << 1) + 1, root.left);
        if (root.right != null) recoverTree((val << 1) + 2, root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}