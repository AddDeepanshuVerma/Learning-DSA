package _18_TREE.algo;

public class _31_BinarySearchTree {
    Node root;

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        _31_BinarySearchTree bt = new _31_BinarySearchTree();
        int[] arr = {8, 7, 12, 15, 2, 5, 11};

        for (int num : arr) bt.insert(num);
        bt.printTree();
    }

    public void insert(int val) {
        root = solve(root, val);
    }

    private Node solve(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = solve(root.left, val);
        } else {
            root.right = solve(root.right, val);
        }
        return root;
    }

    public void printTree() {
        System.out.println("InOrder Traversal : ");
        inOrder(root);

        System.out.println("\nPreOrder Traversal : ");
        preOrder(root);

        System.out.println("\nPostOrder Traversal : ");
        postOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

}

