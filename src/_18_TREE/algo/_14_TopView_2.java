package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.TreeMap;

public class _14_TopView_2 {

    public static void main(String[] args) {
        index = -1;
        int[] arr2 = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
        int[] arr = {1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
        leveOrderDiagram(root);
        System.out.println();
        System.out.println("--------------");

        topView(root);
    }

    private static void topView(TreeNode root) {
        ArrayDeque<Duo> queue = new ArrayDeque<Duo>();
//        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        if (root == null) return;

        queue.offer(new Duo(root, 0));
        while (!queue.isEmpty()) {
            Duo pop = queue.remove();
            TreeNode node = pop.node;
            int level = pop.level;

            map.putIfAbsent(level, node);
            if (node.left != null) queue.offer(new Duo(node.left, level - 1));
            if (node.right != null) queue.offer(new Duo(node.right, level + 1));
        }
        for (TreeNode value : map.values()) {
            System.out.print(value.val + " ");
        }

    }

//===================================================================================================================

    private static class Duo {
        TreeNode node;
        int level;

        public Duo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static int index;

    static class TreeNode {
        int val;
        TreeNode left;
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
