package _18_TREE.algo;

class _33_Floor_In_BST {

    // GFG : Using loop
    public int findFloor(TreeNode node, int x) {
        int floor = -1;
        while (node != null) {
            if (node.data == x) {
                /*floor = x;
                break;*/
                return x;
            } else if (node.data < x) {
                floor = node.data;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return floor;
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