package _18_TREE.algo;

import java.util.HashMap;

class _18_BuildTree_105_Pre_In {
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder values against their indexes for O(1) time index retrieval
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        int preS = 0, preE = preorder.length - 1;
        int inS = 0, inE = inorder.length - 1;

        TreeNode root = solve(preorder, preS, preE, inorder, inS, inE, map);
        return root;
    }

    private static TreeNode solve(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE, HashMap<Integer, Integer> map) {
        if (preS > preE || inS > inE) return null;

        TreeNode root = new TreeNode(preorder[preS]);
        int diff = map.get(root.val) - inS;

        root.left = solve(preorder, preS + 1, preS + diff, inorder, inS, inS + diff + 1, map);
        root.right = solve(preorder, preS + diff + 1, preE, inorder, inS + diff + 1, inE, map);

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