package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _5_PostOrder_Iterative {
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

    static void postOrderTraversal(TreeNode root) {
        if (root == null) /* System.out.print(-1 + " ") */ return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    static List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.addFirst(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pollFirst();
            stack2.addFirst(temp);
            if (temp.left != null) stack1.addFirst(temp.left);
            if (temp.right != null) stack1.addFirst(temp.right);
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pollFirst().val);
        }
        return ans;
    }

    static List<Integer> postOrder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        if(root == null) return ans;

        stack1.addFirst(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pollFirst();
            ans.addFirst(temp.val);
            if (temp.left != null) stack1.addFirst(temp.left);
            if (temp.right != null) stack1.addFirst(temp.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, 8, -1, -1};
        TreeNode root = createTree(arr);
//        preOrderTraversal(root);
        postOrderTraversal(root);

        System.out.println(postOrder(root));
    }
}
