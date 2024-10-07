package _18_TREE.algo;

import java.util.HashMap;

class _19_BuildTree_106_Post_In {
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        int postS = 0, postE = postorder.length - 1;
        int inS = 0, inE = inorder.length - 1;

        TreeNode root = solve(postorder, postS, postE, inorder, inS, inE, map);
        return root;
    }

    private static TreeNode solve(int[] postorder, int postS, int postE, int[] inorder, int inS, int inE, HashMap<Integer, Integer> map) {
        if (postS > postE || inS > inE) return null;

        TreeNode root = new TreeNode(postorder[postE]);
        int diff = map.get(root.val) - inS;

        root.left = solve(postorder, postS, postS + diff - 1, inorder, inS, inS + diff - 1, map);
        root.right = solve(postorder, postS + diff, postE - 1, inorder, inS + diff + 1, inE, map);

        return root;
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