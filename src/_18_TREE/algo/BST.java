package _18_TREE.algo;

import com.sun.jdi.Value;

public class BST {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    static boolean search(Node root, int val) {
        if (root == null) return false;

        if (root.val == val) {
            return true;
        } else if (root.val < val) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // with explanation
    static Node delete2(Node root, int val) {
        if (root == null) return root;

        if (root.val < val) {
            root.right = delete(root.right, val);
        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else {
            //case 1 : this root has no child
            if (root.left == null && root.right == null) return null;

            //case 2 : this root has one child left/right
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3 : this root has both child
            // find the left most successor of this node and put its value with our node
            // now that successor value is the extra once hence delete it as well
            Node LMS = getLMSuccessor(root.right);
            root.val = LMS.val;
            // now update our root's right branch after deleting that value from right side
            root.right = delete(root.right, LMS.val);
        }

        return root;
    }

    static Node delete(Node root, int val) {
        if (root == null) return null;

        if (root.val < val) root.right = delete(root.right, val);
        else if (root.val > val) root.left = delete(root.left, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.val = getLMSuccessor(root.right).val;
            root.right = delete(root.right, root.val);
        }
        return root;
    }


    private static Node getLMSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 3, 1, 4, 6, 10, 11, 14, 7};
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        boolean ans = search(root, 9);
        System.out.println(ans);

        inOrder(root);
        root = delete(root, 8);
        System.out.println();
        inOrder(root);

/*        for (int val : arr) {
            System.out.println("deleting value : " + val);
            root = delete(root, val);
            inOrder(root);
            if (root != null) {
                System.out.println("\nupdated root.val = " + root.val);
                System.out.println("--------------------------------");
            }
        }
        System.out.println("root = " + root);*/



    }
}
