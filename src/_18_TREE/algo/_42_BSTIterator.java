package _18_TREE.algo;

import java.util.ArrayDeque;

class _42_BSTIterator {
    private final ArrayDeque<TreeNode> stack;

    public _42_BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        fillRootLeft(root);
    }

    private void fillRootLeft(TreeNode root) {
        for (; root != null; stack.push(root), root = root.left) {
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        fillRootLeft(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
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