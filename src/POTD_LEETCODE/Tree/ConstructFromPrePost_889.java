package POTD_LEETCODE.Tree;

import java.util.HashMap;

class ConstructFromPrePost_889 {
    public static void main(String[] args) {
        int[] preorder = {2, 1, 3};
        int[] postorder = {3, 1, 2};
        var obj = new ConstructFromPrePost_889();
        TreeNode treeNode = obj.constructFromPrePost(preorder, postorder);
        printTree(treeNode);

    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        int n = preorder.length;
        return dfs(0, n - 1, 0, n - 1, preorder, postorder, map);
    }

    private TreeNode dfs(int preStart, int preEnd, int postStart, int postEnd, int[] pre, int[] post, HashMap<Integer, Integer> map) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;

        int leftRoot = pre[preStart + 1];
        int count = map.get(leftRoot) - postStart + 1;
        root.left = dfs(preStart + 1, preStart + count, postStart, postStart + count - 1, pre, post, map);
        root.right = dfs(preStart + count + 1, preEnd, postStart + count, postEnd, pre, post, map);
        return root;
    }

    private TreeNode solve(int i, int j, int k, int l, int[] pre, int[] post, HashMap<Integer, Integer> map) {
        if (i > j) return null;

        TreeNode root = new TreeNode(pre[i]);
        if (i == j) return root;

        int leftRootIndex = map.get(pre[i + 1]);
        int count = leftRootIndex - k + 1;
        root.left = solve(i + 1, i + count, k, leftRootIndex, pre, post, map);
        root.right = solve(i + count + 1, j, leftRootIndex + 1, l, pre, post, map);
        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}