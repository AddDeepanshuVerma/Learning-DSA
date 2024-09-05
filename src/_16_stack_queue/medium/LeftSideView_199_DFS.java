package _16_stack_queue.medium;

import java.util.ArrayList;
import java.util.List;

class LeftSideView_199_DFS {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int level = 0;
//        rightView(root, list, level);
        leftView(root, list, level);
        return list;
    }

    private void rightView(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if (level == list.size()) list.add(root.val);
        rightView(root.right, list, level + 1);// there is a reason why right child is being explored first
        rightView(root.left, list, level + 1);
    }

    private void leftView(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if(level == list.size()) list.add(root.val);
        leftView(root.left, list, level + 1); // there is a reason why left child is being explored first
        leftView(root.right, list, level + 1);
    }
}