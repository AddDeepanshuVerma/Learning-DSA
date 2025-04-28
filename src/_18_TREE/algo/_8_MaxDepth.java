package _18_TREE.algo;

import java.util.ArrayDeque;

public class _8_MaxDepth {
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

    static void leveOrderDiagram(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                System.out.print(node.val + " ");
                if (node.left != null) q.offerLast(node.left);
                if (node.right != null) q.offerLast(node.right);
            }
            if (!q.isEmpty()) System.out.println();
        }
    }

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, 8, -1, -1};
        TreeNode root = createTree(arr);
        leveOrderDiagram(root);
        System.out.println();

        int depth = maxDepthOfTree(root);
        System.out.println("\n max depth = " + depth);
    }

    private static int maxDepthOfTree(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepthOfTree(root.left);
        int right = maxDepthOfTree(root.right);
        return Math.max(left, right) + 1;
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
