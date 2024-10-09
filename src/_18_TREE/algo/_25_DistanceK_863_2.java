package _18_TREE.algo;

import java.util.*;

class _25_DistanceK_863_2 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        create a map having child -> parent relationship : USING BFS
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        createChildToParentMapping(root, map);

//        just explore all available paths with distance k, don't explore already visited paths
        return explore(target, k, map);
    }

    // BFS
    private static void createChildToParentMapping(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            TreeNode left = parent.left;
            TreeNode right = parent.right;

            if (left != null) {
                map.put(left, parent);
                q.addFirst(left);
            }
            if (right != null) {
                map.put(right, parent);
                q.addFirst(right);
            }
        }
    }

    // BFS
    private static List<Integer> explore(TreeNode target, int k, HashMap<TreeNode, TreeNode> map) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currDistance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (currDistance == k) break;
            currDistance++;

            for (int i = 0; i < size && !q.isEmpty(); i++) {
                TreeNode poll = q.poll();
                if (poll.left != null && !visited.contains(poll.left)) {
                    visited.add(poll.left);
                    q.offer(poll.left);
                }
                if (poll.right != null && !visited.contains(poll.right)) {
                    visited.add(poll.right);
                    q.offer(poll.right);
                }

                TreeNode parent = map.get(poll);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
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