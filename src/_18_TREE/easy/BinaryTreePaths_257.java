package _18_TREE.easy;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths_257 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, list, sb);
        return list;
    }

    private void dfs(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }

        sb.append("->");
        dfs(root.left, list, sb);
        dfs(root.right, list, sb);
        sb.setLength(len);
    }
}