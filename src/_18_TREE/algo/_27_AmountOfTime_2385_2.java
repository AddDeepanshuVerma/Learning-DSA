package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//BFS : to find node with val = start; BFS : to create map with child->Parent; BFS : to find max distance from target node
class _27_AmountOfTime_2385_2 {
    int amountOfTime(TreeNode root, int start) {
//        find the node and create child->Parent mapping at the same time
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = createMapping(root, map, start);
//        now simply traverse through all possible ways ans count the maximum we had to travel ( don't explore visited nodes again)
        return BFS(target, map);
    }

    private TreeNode createMapping(TreeNode root, HashMap<TreeNode, TreeNode> map, int start) {
        if (root == null) return null;
        TreeNode target = null;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            TreeNode left = parent.left, right = parent.right;
            if (left != null) {
                map.put(left, parent);
                q.offer(left);
            }
            if (right != null) {
                map.put(right, parent);
                q.offer(right);
            }
            if (parent.val == start) target = parent;
        }
        return target;
    }

    private int BFS(TreeNode target, HashMap<TreeNode, TreeNode> map) {
        Set<TreeNode> visited = new HashSet<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.offer(target);
        visited.add(target);
        int distance = -1;

        while (!q.isEmpty()) {
            distance++;
            int size = q.size();

            for (int i = 0; i < size && !q.isEmpty(); i++) {
                TreeNode poll = q.poll(), parent = map.get(poll);
                TreeNode left = poll.left, right = poll.right;

                if (left != null && !visited.contains(left)) {
                    visited.add(left);
                    q.offer(left);
                }
                if (right != null && !visited.contains(right)) {
                    visited.add(right);
                    q.offer(right);
                }
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }

        }
        return distance;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}