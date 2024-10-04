package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _6_Pre_In_Post_Traversal {
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

    private static void pre_In_Post_Traversal(TreeNode root) {

        record Pair<K, V>(K node, V num) {
        }

        ArrayDeque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null) return;

        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            var it = stack.pop();

            switch (it.num) {
                case 1 -> {
                    pre.add(it.node.val);
                    stack.push(new Pair<>(it.node, it.num + 1));
                    if (it.node.left != null) {
                        stack.push(new Pair<>(it.node.left, 1));
                    }
                }
                case 2 -> {
                    in.add(it.node.val);
                    stack.push(new Pair<>(it.node, it.num + 1));
                    if (it.node.right != null) {
                        stack.push(new Pair<>(it.node.right, 1));
                    }
                }
                case 3 -> {
                    post.add(it.node.val);
                }
            }

        }
        System.out.println("pre = " + pre);
        System.out.println("in = " + in);
        System.out.println("post = " + post);
    }

    public static void main(String[] args) {
        index = -1;
        int[] arr2 = {1, 2, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1, 7, -1, -1};
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
//        preOrderTraversal(root);
//        System.out.println();

        pre_In_Post_Traversal(root);
    }
}
