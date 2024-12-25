package POTD_LEETCODE.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class LargestValues_515 {
    // BFS
    public List<Integer> largestValues_BFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if (root == null) return ans;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode poll = q.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }
            ans.add(max);
        }
        return ans;
    }

    // DFS
    public List<Integer> largestValues_DFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        dfs(root, ans, level);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;

        if (list.size() == level) {
            list.add(root.val);
        } else {
            if (root.val > list.get(level)) {
                list.set(level, root.val);
            }
        }

        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
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