package _18_TREE.easy;

import java.util.ArrayList;

class SumOfLeftLeaves_404 {
    /*// wrong understanding of prob, hence wrong solution
    public int sumOfLeftLeaves(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        int sum = ans.stream().mapToInt(item -> item).sum();
        return sum - root.val;
    }
    private void helper(TreeNode root, int level, ArrayList<Integer> list) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root.val);
        }
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }*/

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else sum += dfs(root.left);
        }
        sum += dfs(root.right);
        return sum;
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