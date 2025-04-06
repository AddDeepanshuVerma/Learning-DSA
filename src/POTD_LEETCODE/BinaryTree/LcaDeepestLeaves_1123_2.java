package POTD_LEETCODE.BinaryTree;

class LcaDeepestLeaves_1123_2 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // first find the deepest depth of this tree
        int d = depth(root);
        return LCA(0, d, root);
    }

    private TreeNode LCA(int curr, int d, TreeNode root) {
        if (root == null) return null;
        if (curr == d) return root;

        TreeNode left = LCA(curr + 1, d, root.left);
        TreeNode right = LCA(curr + 1, d, root.right);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}