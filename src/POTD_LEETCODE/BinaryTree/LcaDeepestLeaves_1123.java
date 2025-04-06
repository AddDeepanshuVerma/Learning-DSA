package POTD_LEETCODE.BinaryTree;

class LcaDeepestLeaves_1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // first find the deepest depth of this tree
        int d = depth(0, root);
        return LCA(0, d - 1, root);
    }

    private TreeNode LCA(int curr, int d, TreeNode root) {
        if (root == null) return null;
        if (curr == d) return root;

        TreeNode left = LCA(curr + 1, d, root.left);
        TreeNode right = LCA(curr + 1, d, root.right);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


    private int depth(int level, TreeNode root) {
        if (root == null) return level;

        int left = depth(level + 1, root.left);
        int right = depth(level + 1, root.right);
        return Math.max(right, left);
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