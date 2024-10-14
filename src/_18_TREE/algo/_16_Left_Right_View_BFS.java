package _18_TREE.algo;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _16_Left_Right_View_BFS {
    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
        preOrderTraversal(root);

        System.out.println(leftView(root));
        System.out.println(rightView(root));
    }

    private static List<Integer> leftView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return list;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peek().val);

            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                // first add left so that new level's first element that is at the front of queue is left one
                if (remove.left != null) queue.add(remove.left);
                if (remove.right != null) queue.add(remove.right);
            }
        }
        return list;
    }

    private static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return list;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peek().val);

            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                // first add right so that new level's first element that is at the front of queue is right one
                if (remove.right != null) queue.add(remove.right);
                if (remove.left != null) queue.add(remove.left);
            }
        }
        return list;
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
