package _18_TREE.easy;

import java.util.ArrayList;
import java.util.List;

class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
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