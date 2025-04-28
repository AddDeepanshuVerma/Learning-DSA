package _18_TREE.algo;

import java.util.ArrayList;
import java.util.List;

public class _22_GetPath {

    static void getPath(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        System.out.println(solve(root, k, ans) ? ans : "None");
    }

    private static boolean solve(TreeNode root, int k, List<Integer> ans) {
        if (root == null) return false;

        ans.add(root.val);
        if (root.val == k) return true;

        boolean left = solve(root.left, k, ans);
        boolean right = solve(root.right, k, ans);
        if (left || right) return true;

        ans.removeLast();

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        getPath(root, 8);
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
