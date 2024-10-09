package _18_TREE.algo;

public class _26_Find_Node {

    static TreeNode findNode(TreeNode root, int start) {
        return find(root, start);
    }

    private static TreeNode find(TreeNode root, int start) {
        if (root == null) return null;

        if (root.val == start) return root;

        TreeNode left = find(root.left, start);
        if (left != null) return left;

        return find(root.right, start);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode found = find(root, 2);
        System.out.println(found == null ? "None" : found.val);
        preOrder(found);
    }

    private static void preOrder(TreeNode found) {
        if (found == null) return;
        System.out.print(found.val + " ");
        preOrder(found.left);
        preOrder(found.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
