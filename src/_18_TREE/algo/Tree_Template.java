package _18_TREE.algo;

public class Tree_Template {
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

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1, 7, -1, -1};
        TreeNode root = createTree(arr);
        preOrderTraversal(root);
    }
}
