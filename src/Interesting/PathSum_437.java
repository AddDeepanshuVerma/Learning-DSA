package Interesting;

import java.util.HashMap;
import java.util.Map;

class PathSum_437 {
    private int res;
    private Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>(Map.of(0L, 1));
        res = 0;
        helper(root, 0L, targetSum);
        return res;
    }

    private void helper(TreeNode root, long sum, int targetSum) {
        if (root == null) return;
        sum += root.val;
        res += map.getOrDefault(sum - targetSum, 0);

        map.merge(sum, 1, Integer::sum);
        helper(root.left, sum, targetSum);
        helper(root.right, sum, targetSum);
        map.merge(sum, -1, Integer::sum);
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