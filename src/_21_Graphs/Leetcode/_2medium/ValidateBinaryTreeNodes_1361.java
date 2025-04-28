package _21_Graphs.Leetcode._2medium;

class ValidateBinaryTreeNodes_1361 {
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left != -1 && !dsu.union(i, left)) {
                return false;
            }
            if (right != -1 && !dsu.union(i, right)) {
                return false;
            }
        }

        return dsu.isSingleComponent();
    }

    static class DSU {
        int[] parent;
        int components;

        public DSU(int n) {
            components = n;
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        // if we are connecting to any new node then we need to confirm two things
        // first it should not the part of root node already
        // and that new node has to be either single component or leader of his component (so that we could avoid diamond figure)
        boolean union(int root, int child) {
            int rootParent = find(root);
            int childParent = find(child);
            if (rootParent == childParent) {
                return false; // both are already connected
            }
            if (childParent != child) {
                return false; // node which is going to connect has to be a single node
            }
            parent[childParent] = rootParent;
            components--;
            return true;
        }


        public boolean isSingleComponent() {
            return components == 1;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] left = {1, -1, -1};
        int[] right = {-1, -1, 1};
        System.out.println(validateBinaryTreeNodes(n, left, right));
    }
}