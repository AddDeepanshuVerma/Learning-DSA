package _18_TREE.algo;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
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
        printInOrderTraversal(root);

        System.out.println("\nPreOrder Traversal : ");
        printPreOrderTraversal(root);

        System.out.println("\nPostOrder Traversal : ");
        printPostOrderTraversal(root);
    }

    private void printPreOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }

    private void printInOrderTraversal(Node root) {
        if (root == null) return;
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }

    private void printPostOrderTraversal(Node root) {
        if (root == null) return;
        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

}

