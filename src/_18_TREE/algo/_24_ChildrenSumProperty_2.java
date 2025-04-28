package _18_TREE.algo;

public class _24_ChildrenSumProperty_2 {

    static void childrenSum_Property(TreeNode root) {
        if (root == null) return;

        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;

        int max = Math.max(root.val, right + left);

        if (root.left != null) root.left.val = max;
        if (root.right != null) root.right.val = max;

        childrenSum_Property(root.left);
        childrenSum_Property(root.right);

        if (root.left == null && root.right == null) {
            root.val = max;
        } else {
            left = root.left != null ? root.left.val : 0;
            right = root.right != null ? root.right.val : 0;
            root.val = right + left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrderTraversal(root);
        System.out.println();
        childrenSum_Property(root);
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
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
