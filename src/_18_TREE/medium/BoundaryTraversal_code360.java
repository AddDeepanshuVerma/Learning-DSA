package _18_TREE.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal_code360 {
    static ArrayList<Integer> boundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        // if node is null, return empty list
        if (root == null) return ans;

        // if node is leaf node, return just list with node value
        if (isLeaf(root)) {
            ans.add(root.data);
            return ans;
        }

        // now we will go through node->left->leaf->right
        // 1. store node value in list
        ans.add(root.data);
        // 2. store all left boundary nodes value in the list
        addLeftBoundary(root, ans);
        // 3. store all leaf nodes value in the list
        addLeaves(root, ans);
        // 4. store all right boundary nodes value in the list
        addRightBoundary(root, ans);

        return ans;
    }

    private static void addRightBoundary(TreeNode root, List<Integer> ans) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        TreeNode temp = root.right;
        while (temp != null) {
            if (!isLeaf(temp)) stack.push(temp.data);
            temp = temp.right != null ? temp.right : temp.left;
        }

        while (!stack.isEmpty()) ans.add(stack.pop());
    }

    private static void addLeaves(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode temp = root.left;
        while (temp != null) {
            if (!isLeaf(temp)) ans.add(temp.data);
            temp = temp.left != null ? temp.left : temp.right;
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.data = val;
        }
    }
}
