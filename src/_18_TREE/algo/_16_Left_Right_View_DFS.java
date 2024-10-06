package _18_TREE.algo;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

@Description("DFS is more optimized in case of space complexity as we are storing maximum a path, Though if tree is an degenerate or pathological binary tree it will be same as BFS S.C.")
public class _16_Left_Right_View_DFS {
    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
        preOrderTraversal(root);

        leftView(root);
        rightView(root);
    }

    private static void leftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        leftDFS(root, 0, ans);
        System.out.println(ans);
    }

    // root->left->right traversal
    private static void leftDFS(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) ans.add(root.val);

        leftDFS(root.left, level + 1, ans);
        leftDFS(root.right, level + 1, ans);
    }

    private static void rightView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightDFS(root, 0, ans);
        System.out.println(ans);
    }

    // root->right->left traversal
    private static void rightDFS(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) ans.add(root.val);

        rightDFS(root.right, level + 1, ans);
        rightDFS(root.left, level + 1, ans);
    }

//===================================================================================================================

    static int index;

    static class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode createTree(int[] arr) {
        index++;
        if (arr[index] == -1) return null;

        TreeNode temp = new TreeNode(arr[index]);
        temp.left = createTree(arr);
        temp.right = createTree(arr);
        return temp;
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) {
//            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }


}
