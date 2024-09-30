package _18_TREE.algo;

import java.util.ArrayDeque;

public class BinaryTreesYT {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildBinaryTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node temp = new Node(nodes[index]);
            temp.left = buildBinaryTree(nodes);
            temp.right = buildBinaryTree(nodes);
            return temp;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }

        public static void leveOrder(Node root) {
            if (root == null) return;

            ArrayDeque<Node> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.pollFirst();
                System.out.print(temp.val + " ");
                if (temp.left != null) q.offerLast(temp.left);
                if (temp.right != null) q.offerLast(temp.right);
            }
        }

        public static void leveOrderDiagram(Node root) {
            if (root == null) return;

            ArrayDeque<Node> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node node = q.pollFirst();
                    System.out.print(node.val + " ");
                    if (node.left != null) q.offerLast(node.left);
                    if (node.right != null) q.offerLast(node.right);
                }
                if (!q.isEmpty()) System.out.println();
            }
        }

        public static int countOfNodes(Node root) {
            if (root == null) return 0;

            int leftBranchCount = countOfNodes(root.left);
            int rightBranchCount = countOfNodes(root.right);
            return leftBranchCount + rightBranchCount + 1;
        }
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildBinaryTree(nodes);
//        BinaryTree.preOrder(root);
//        BinaryTree.inOrder(root);
//        BinaryTree.postOrder(root);
//        BinaryTree.leveOrder(root);
//        BinaryTree.leveOrderDiagram(root);
        int count = BinaryTree.countOfNodes(root);
        System.out.println("countOfNodes : " + count);



    }
}
