package _18_TREE.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class _44_RecoverTree_99 {
    List<Integer> inOrder;
    int index;

    public void recoverTree(TreeNode root) {
        /*
         * Do any traversal, store elements in list and sort it
         * Now again do a inOrder traversal of this BST and whenever value does not match with the corresponding list traversal, change it
         * */
        inOrder = new ArrayList<>();
        storeValues(root);

        Collections.sort(inOrder);

        index = -1;
        correctInOrder(root);
    }

    private void correctInOrder(TreeNode root) {
        if (root == null) return;
        correctInOrder(root.left);
        if (root.val != inOrder.get(++index))
            root.val = inOrder.get(index);
        correctInOrder(root.right);
    }

    private void storeValues(TreeNode root) {
        if (root == null) return;
        inOrder.add(root.val);
        storeValues(root.left);
        storeValues(root.right);
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