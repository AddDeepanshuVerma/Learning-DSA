package _16_stack_queue.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class RightSideView_199_DFS_BFS {
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

    public List<Integer> rightSideView(TreeNode root) {
        // find level order traversal
        List<List<Integer>> allNodes = levelOrder_BFS(root);
        // Take last element from all subLists
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> subList : allNodes) {
            ans.add(subList.getLast());
        }
        return ans;
    }

    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> sList = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                sList.add(temp.val);
                nodes.add(temp);
            }

            list.add(sList);

            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }


    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, res, 0);
        return res;
    }

    public void level(TreeNode r, List<List<Integer>> res, int level) {
        if (r == null) return;
        if (level >= res.size()) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(r.val);
            res.add(l1);
        } else {
            List<Integer> l2 = res.get(level);
            l2.add(r.val);
        }
        level(r.left, res, level + 1);
        level(r.right, res, level + 1);
    }
}