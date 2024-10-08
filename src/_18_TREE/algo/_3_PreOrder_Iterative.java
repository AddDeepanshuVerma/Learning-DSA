package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _3_PreOrder_Iterative {
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
        if (root == null) /* System.out.print(-1 + " ") */ return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.addFirst(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollFirst();
            ans.add(pop.val);

            if (pop.right != null) stack.addFirst(pop.right);
            if (pop.left != null) stack.addFirst(pop.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
//        preOrderTraversal(root);

        System.out.println(preOrder(root));
    }
}
