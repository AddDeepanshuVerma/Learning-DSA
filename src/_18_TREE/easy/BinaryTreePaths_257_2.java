package _18_TREE.easy;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths_257_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> a1 = new ArrayList<>();
        traverse(root, a1, "");
        return a1;
    }

    static void traverse(TreeNode root, List<String> a1, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            a1.add(s + root.val);
            return;
        }

        traverse(root.left, a1, s + root.val + "->");
        traverse(root.right, a1, s + root.val + "->");
    }
}