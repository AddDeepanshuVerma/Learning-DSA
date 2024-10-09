package _18_TREE.algo;

import java.util.ArrayList;
import java.util.List;

public class _29_Codec {
    public static void main(String[] args) {
        int val = -1;
        String str = String.valueOf(val);
        System.out.println(Integer.parseInt(str));
    }

    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        preOrder(root, list);
        return String.join(",", list);
    }

    private void preOrder(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.val));
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = -1;
        return insertPreOrder(arr);
    }

    private TreeNode insertPreOrder(String[] arr) {
        index++;
        if (arr[index].equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        root.left = insertPreOrder(arr);
        root.right = insertPreOrder(arr);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}