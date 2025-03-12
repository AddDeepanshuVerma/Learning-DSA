package _21_Graphs.Leetcode._2medium;

class _7PossibleBipartition_886_DSU {
    public static void main(String[] args) {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(3, dislikes));
    }

    // First we check if disliked edges are part of same parent then return false
    // else put them in two different parent components combining with such value that would node exist in nodes ever
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        parent = new int[n << 1 + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            int uParent = find(u);
            int vParent = find(v);

            if (uParent == vParent) return false;

            union(u, v + n);
            union(v, u + n);
        }
        return true;
    }

    static int[] parent;

    public static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
//        if (aParent != bParent)
        parent[bParent] = aParent;
    }

}