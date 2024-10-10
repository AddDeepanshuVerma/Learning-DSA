package _18_TREE.algo;

class _33_Ceil_In_BST {

    // GFG : Using loop
    public int findCeil(TreeNode node, int x) {
        int ceil = -1;
        while (node != null) {
            if (node.data == x) {
                ceil = x;
                break;
            } else if (node.data < x) {
                node = node.right;
            } else if (node.data > x) {
                ceil = node.data;
                node = node.left;
            }
        }
        return ceil;
    }

    // using recursion
    public int findCeilBST(TreeNode root, int key) {
        if (root == null) return -1;

        if (root.data == key) return key;
        else if (root.data < key) return findCeilBST(root.right, key);
        else {
            int option1 = root.data;
            int option2 = findCeilBST(root.left, key);
            return option2 >= key ? Math.min(option2, option1) : option1;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}