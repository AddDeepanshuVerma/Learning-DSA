package POTD_LEETCODE.Tree;

import java.util.HashSet;

class FindElements_1261_2 {
    TreeNode root; // we don't even need to store this root to after storing all values in hashset
    HashSet<Integer> set;

    public FindElements_1261_2(TreeNode root) {
        this.root = root;
        set = new HashSet<>();
        recoverTree(0, root); // first node value is always 0
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void recoverTree(int val, TreeNode curr) {
        curr.val = val;
        set.add(val);
        if (curr.left != null) recoverTree((val << 1) + 1, curr.left);
        if (curr.right != null) recoverTree((val << 1) + 2, curr.right);
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