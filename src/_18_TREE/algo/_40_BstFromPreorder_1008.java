package _18_TREE.algo;

import _09_BinarySearch.BinarySearchOnAnswers.Templet;

class _40_BstFromPreorder_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int num : preorder) {
            root = insertTree(root, num);
        }
        return root;
    }

    private TreeNode insertTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertTree(root.left, val);
        } else {
            root.right = insertTree(root.right, val);
        }

        return root;
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