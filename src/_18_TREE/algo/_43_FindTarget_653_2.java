package _18_TREE.algo;

import java.util.Stack;

class _43_FindTarget_653_2 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int i = l.next();
        int j = r.next();
        while (i < j) {
            int sum = i + j;
            if (sum == k) return true;
            else if (sum < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

    static class BSTIterator {
        Stack<TreeNode> st = new Stack<>();
        boolean reverse;

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            addElements(root);
        }

        public void addElements(TreeNode root) {
            while (root != null) {
                st.push(root);
                if (reverse) {
                    root = root.right;
                } else root = root.left;
            }
        }

        public int next() {
            TreeNode node = st.pop();
            if (reverse) {
                addElements(node.left);
            } else addElements(node.right);
            return node.val;
        }
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



    