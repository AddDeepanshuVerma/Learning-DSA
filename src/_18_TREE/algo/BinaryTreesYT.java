package _18_TREE.algo;

import java.util.ArrayDeque;

public class BinaryTreesYT {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index;

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

        public static int sumOfNodes(Node root) {
            if (root == null) return 0;

            int leftBranchSum = sumOfNodes(root.left);
            int rightBranchSum = sumOfNodes(root.right);

            return leftBranchSum + rightBranchSum + root.val;
        }

        public static int heightOfTree(Node root) {
            if (root == null) return 0;

            int leftBranchHeight = heightOfTree(root.left);
            int rightBranchHeight = heightOfTree(root.right);

            return Math.max(leftBranchHeight, rightBranchHeight) + 1;
        }

        public static int diameterOfTreeVaiRoot(Node root) {
            if (root == null) return 0;

            int leftBranchMaxHeight = heightOfTree(root.left);
            int rightBranchMaxHeight = heightOfTree(root.right);

            return leftBranchMaxHeight + rightBranchMaxHeight + 1;
        }

        //TC :: O(n * n)
        public static int diameterOfTree_n2(Node root) {
            if (root == null) return 0;

            int leftDia = diameterOfTree_n2(root.left);     // max diameter lies in left subtree itself
            int rightDia = diameterOfTree_n2(root.right);   // max diameter lies in right subtree itself
            int diaViaRoot = diameterOfTreeVaiRoot(root); // max diameter lies via root itself

            return Math.max(diaViaRoot, Math.max(leftDia, rightDia));
        }

        static class TreeInfo {
            int dia;
            int ht;

            public TreeInfo(int diameter, int height) {
                this.dia = diameter;
                this.ht = height;
            }

            @Override
            public String toString() {
                return "TreeInfo{" + "diameter=" + dia + ", height=" + ht + '}';
            }
        }

        //TC :: O(n)
        public static TreeInfo diameterOfTree_n(Node root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }
            TreeInfo left = diameterOfTree_n(root.left);
            TreeInfo right = diameterOfTree_n(root.right);

            int currDiameter = Math.max(Math.max(left.dia, right.dia), left.ht + right.ht + 1);
            int currHeight = Math.max(left.ht, right.ht) + 1;
            return new TreeInfo(currDiameter, currHeight);
        }

        public static boolean isSubTree(Node root, Node subRoot) {
            if (subRoot == null) return true;
            if (root == null) return false;

            return isIdentical(root, subRoot) || isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

        private static boolean isIdentical(Node root, Node subRoot) {
            if (subRoot == null && root == null) return true;
            if (subRoot == null || root == null) return false;
            if (root.val == subRoot.val) {
                return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
            }
            return false;
        }

    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree.index = -1;
        Node root = BinaryTree.buildBinaryTree(nodes);
//        BinaryTree.preOrder(root);
//        BinaryTree.inOrder(root);
//        BinaryTree.postOrder(root);
//        BinaryTree.leveOrder(root);
//        BinaryTree.leveOrderDiagram(root);
//        int count = BinaryTree.countOfNodes(root);
//        System.out.println("countOfNodes : " + count);
//
//        int sum = BinaryTree.sumOfNodes(root);
//        System.out.println("sumOfNodes = " + sum);
//
//        int height = BinaryTree.heightOfTree(root);
//        System.out.println("heightOfTree = " + height);
//
//        int diameter = BinaryTree.diameterOfTreeVaiRoot(root);
//        System.out.println("diameter = " + diameter);
//
//        int diameter1 = BinaryTree.diameterOfTree_n2(root);
//        System.out.println("diameter1 = " + diameter1);
//
//        var treeInfo = BinaryTree.diameterOfTree_n(root);
//        System.out.println(treeInfo);

//        int[] subNodes = {2, 4, -1, -1, 5, -1, -1};
//        BinaryTree.index = -1;
//        Node subRoot = BinaryTree.buildBinaryTree(subNodes);
//        boolean ans = BinaryTree.isSubTree(root, subRoot);
//        System.out.println("isSubTree = " + ans);

    }
}
