package _21_Graphs.Leetcode._2medium;

class ValidateBinaryTreeNodes_1361_2 {
     int[] parent;
     int components;

    public  boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        components = n;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left != -1 && !union(i, left)) {
                return false;
            }
            if (right != -1 && !union(i, right)) {
                return false;
            }
        }

        return isSingleComponent();
    }

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    boolean union(int root, int node) {
        int rootParent = find(root);
        int nodeParent = find(node);
        if (rootParent == nodeParent || nodeParent != node) return false;
        parent[nodeParent] = rootParent;
        components--;
        return true;
    }

    public boolean isSingleComponent() {
        return components == 1;
    }
}