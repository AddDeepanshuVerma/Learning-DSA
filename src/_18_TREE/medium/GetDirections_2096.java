package _18_TREE.medium;

import java.util.*;

class GetDirections_2096 {
    public static void main(String[] args) {
        GetDirections_2096 obj = new GetDirections_2096();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(obj.getDirections(root, 3, 6));

    }

    HashMap<Integer, Integer> childToParent;
    HashMap<Integer, int[]> parentToChildren;

    public String getDirections(TreeNode root, int start, int dest) {
        // get parent to children and child to parent mapping first
        childToParent = new HashMap<>();
        parentToChildren = new HashMap<>();
        dfs(root);

        // now for start do a dfs and search for all 3 directions left, right, parent
        // and as soon as we find out dest value, return true
        Set<Integer> visited = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        visited.add(start);
        route(start, ans, dest, visited);

        return ans.toString();
    }

    private boolean route(int curr, StringBuilder path, int dest, Set<Integer> visited) {
        if (curr == dest) return true;

        if (childToParent.containsKey(curr) && !visited.contains(childToParent.get(curr))) {
            int next = childToParent.get(curr);

            visited.add(next);
            path.append("U");
            if (route(next, path, dest, visited)) return true;

            visited.remove(next);
            path.deleteCharAt(path.length() - 1);
        }

        int[] child = parentToChildren.getOrDefault(curr, new int[2]);
        int left = child[0];
        int right = child[1];
        if (left != 0 && !visited.contains(left)) {
            visited.add(left);
            path.append("L");

            if (route(left, path, dest, visited)) return true;

            visited.remove(left);
            path.deleteCharAt(path.length() - 1);
        }
        if (right != 0 && !visited.contains(right)) {
            visited.add(right);
            path.append("R");

            if (route(right, path, dest, visited)) return true;

            visited.remove(right);
            path.deleteCharAt(path.length() - 1);
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            parentToChildren.computeIfAbsent(root.val, val -> new int[2])[0] = root.left.val;
            childToParent.put(root.left.val, root.val);
        }
        if (root.right != null) {
            parentToChildren.computeIfAbsent(root.val, val -> new int[2])[1] = root.right.val;
            childToParent.put(root.right.val, root.val);
        }

        dfs(root.left);
        dfs(root.right);
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