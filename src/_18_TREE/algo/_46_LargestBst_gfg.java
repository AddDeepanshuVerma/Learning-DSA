package _18_TREE.algo;

class _46_LargestBst_gfg {
    static int count;

    int largestBst(Node root) {
        count = 0;
        customTraverse(root);
        return count;
    }

    private void customTraverse(Node root) {
        if (root == null) return;

        if (checkIfBST(root, null, null)) {
            count = Math.max(count, countOfNodes(root));
        }
        customTraverse(root.left);
        customTraverse(root.right);
    }

    private boolean checkIfBST(Node root, Node minVal, Node maxVal) {
        if (root == null) return true;

        if (minVal != null && root.val <= minVal.val) return false;
        if (maxVal != null && root.val >= maxVal.val) return false;

        return checkIfBST(root.left, minVal, root) && checkIfBST(root.right, root, maxVal);
    }

    private int countOfNodes(Node root) {
        if (root == null) return 0;
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);
        return left + right + 1;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}