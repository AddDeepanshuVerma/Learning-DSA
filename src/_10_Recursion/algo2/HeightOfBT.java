package _10_Recursion.algo2;

public class HeightOfBT {
    static class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Tree(int val) {
            this.val = val;
        }

        public Tree() {
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(-1);
        int h = height(root);
    }

    private static int height(Tree root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }


}
