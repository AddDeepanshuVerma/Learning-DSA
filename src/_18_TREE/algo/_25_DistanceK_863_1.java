package _18_TREE.algo;

import java.util.*;

class _25_DistanceK_863_1 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        create a map having child -> parent relationship : USING BFS
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        createChildToParentMapping(root, map);

//        just explore all available paths with distance k, don't explore already visited paths : USING DFS
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        int currDistance = 0;
        solve(target, visited, currDistance, k, map, ans);
        visited.clear();
        return ans;
    }

    // BFS
    private static void createChildToParentMapping(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            TreeNode left = parent.left, right = parent.right;

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

    // DFS
    private void solve(TreeNode currNode, Set<TreeNode> visited, int currDistance, int k, HashMap<TreeNode, TreeNode> map, List<Integer> ans) {
        if (currNode == null || currDistance > k || visited.contains(currNode)) return;

        visited.add(currNode);

        if (currDistance == k) {
            ans.add(currNode.val);
            return;
        }

        solve(currNode.left, visited, currDistance + 1, k, map, ans);
        solve(currNode.right, visited, currDistance + 1, k, map, ans);
        solve(map.get(currNode), visited, currDistance + 1, k, map, ans);

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