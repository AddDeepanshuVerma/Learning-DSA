package _18_TREE.algo;

import java.util.ArrayDeque;

public class _7_LevelOrder_Traversal {
    static int index;

    static class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // createPreOrderTree
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

    static void leveOrder(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
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
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);

        leveOrder(root);
        System.out.println();
        leveOrderDiagram(root);
    }
}
