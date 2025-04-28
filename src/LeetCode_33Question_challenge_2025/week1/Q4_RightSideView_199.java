package LeetCode_33Question_challenge_2025.week1;

import java.util.ArrayList;
import java.util.List;

class Q4_RightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(0, root, ans);
        return ans;
    }

    private void dfs(int level, TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (ans.size() == level) ans.add(root.val);
        dfs(level + 1, root.right, ans);
        dfs(level + 1, root.left, ans);
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