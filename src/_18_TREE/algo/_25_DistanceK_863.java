package _18_TREE.algo;

import java.util.*;

class _25_DistanceK_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        create a map having child -> parent relationship : USING BFS
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        createChildToParentMapping(root, map);

//        just explore all available paths with distance k, don't explore already visited paths
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        int currDistance = 0;
        solve(target, visited, currDistance, k, map, ans);
        visited.clear();
        return ans;
    }

    // DFS
    private static void createChildToParentMapping(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) return;

        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);

        createChildToParentMapping(root.left, map);
        createChildToParentMapping(root.right, map);
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