package _18_TREE.medium;

import java.util.ArrayList;
import java.util.List;

class FlipMatchVoyage_971 {
    private int idx = 0;
    private List<Integer> ans;

    public List<Integer> flipMatchVoyage2(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        dfs(root, voyage);
        return ans;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root == null) return;
        if (root.val != voyage[idx++]) {
            ans.clear();
            ans.add(-1);
            return;
        }

        if (idx < voyage.length && root.left != null && root.left.val != voyage[idx]) {
            ans.add(root.val);
            dfs(root.right, voyage);
            if (!ans.isEmpty() && ans.getFirst() == -1) return;
            dfs(root.left, voyage);
        } else {
            dfs(root.left, voyage);
            if (!ans.isEmpty() && ans.getFirst() == -1) return;
            dfs(root.right, voyage);
        }
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