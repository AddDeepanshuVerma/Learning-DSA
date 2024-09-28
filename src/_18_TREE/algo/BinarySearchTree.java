package _18_TREE.algo;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        int[] arr = {8, 7, 12, 15, 2, 5, 11};

        for (int num : arr) bt.insert(num);
        bt.printTree();
    }
    /* ================================================== */

    Node root;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        root = solve(root, data);
    }

    private Node solve(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        int val = root.data;
        if (data < val) {
            root.left = solve(root.left, data);
        } else {
            root.right = solve(root.right, data);
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
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

}

