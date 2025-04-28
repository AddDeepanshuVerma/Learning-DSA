package _16_stack_queue.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class LevelOrder_102_BFS {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            List<Integer> sList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                sList.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            list.add(sList);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            List<Integer> sList = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode temp = queue.pollLast();
                sList.add(temp.val);
                nodes.add(temp);
            }

            list.add(sList);

            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
            }
        }
        return list;
    }
}