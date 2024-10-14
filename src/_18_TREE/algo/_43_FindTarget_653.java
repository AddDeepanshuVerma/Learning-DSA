package _18_TREE.algo;

import java.util.HashSet;
import java.util.Set;

class _43_FindTarget_653 {
    private static Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }

    private boolean helper(TreeNode root, int k) {
        if (root == null) return false;

        if (set.contains(Math.abs(k - root.val))) return true;
        set.add(root.val);

        return helper(root.left, k) || helper(root.right, k);
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