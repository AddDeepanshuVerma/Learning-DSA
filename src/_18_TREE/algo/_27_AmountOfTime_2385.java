package _18_TREE.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//DFS : to find node with val = start; DFS : to create map with child->Parent; DFS : to find max distance from target node
class _27_AmountOfTime_2385 {
    int amountOfTime(TreeNode root, int start) {
//        Given that a node with start value is always there in tree, FIRST FIND IT
        TreeNode target = find(root, start);

//        now we need to traverse all the possible ways: left, right & parent
//        for parent, need to create a child-to-parent map
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        createParent(root, map);

//        now simply traverse through all possible ways ans count the maximum we had to travel ( don't explore visited nodes again)
        Set<TreeNode> visited = new HashSet<>();
        int[] maxDistance = new int[1];
        int currDistance = 0;
        DFS(target, maxDistance, currDistance, map, visited);
        return maxDistance[0];
    }

    private void DFS(TreeNode target, int[] maxDistance, int currDistance, HashMap<TreeNode, TreeNode> map, Set<TreeNode> visited) {
        if (target == null || visited.contains(target)) return;

        visited.add(target);
        maxDistance[0] = Math.max(maxDistance[0], currDistance);

        DFS(target.left, maxDistance, currDistance + 1, map, visited);
        DFS(target.right, maxDistance, currDistance + 1, map, visited);
        DFS(map.get(target), maxDistance, currDistance + 1, map, visited);

    }

    private void createParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) return;

        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);

        createParent(root.left, map);
        createParent(root.right, map);
    }

    private static TreeNode find(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = find(root.left, start);
        if (left != null) return left;

        return find(root.right, start);
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