package _18_TREE.algo;

import jdk.jfr.Description;

class _23_LowestCommonAncestor_236 {

/*  Note : there will always be p and q node available in the Tree
    means : even if we find just one element it means second one was his successor somewhere,
    and we don't need to look after that    */
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}