package DailyCodeChallenge.Level_2;

import java.util.ArrayList;
import java.util.List;


class PreorderTraversal_144 {
    List<Integer> ans;

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

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        solve(root);
        return ans;
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        solve(root.left);
        solve(root.right);
    }

    private void solve2(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            solve(root.left);
            solve(root.right);
        }
    }
}