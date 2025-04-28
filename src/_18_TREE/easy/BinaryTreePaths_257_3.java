package _18_TREE.easy;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths_257_3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverse(root, ans, new ArrayList<>());
        return ans;
    }

    static void traverse(TreeNode root, List<String> ans, List<String> path) {
        if (root == null) return;
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            ans.add(String.join("->", new ArrayList<>(path)));
        }

        traverse(root.left, ans, path);
        traverse(root.left, ans, path);
        path.removeLast();
    }
}