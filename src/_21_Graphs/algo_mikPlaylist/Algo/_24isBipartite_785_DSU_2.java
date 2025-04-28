package _21_Graphs.algo_mikPlaylist.Algo;

import jdk.jfr.Description;

@Description("Using one -> one relationship graph structure")
class _24isBipartite_785_DSU_2 {
    /*
     * KeyPoints
     * NOTE: if we want to convert this 1 to 1 relationship to 1 to many, we will make a map<Integer, List<Integer>>
     * and will put all neighbours of a single source in a same component
     * and to do so we need the first neighbour, which we will be union with all others.
     * to do so in java :
     *            if(map.size() == 0) continue;
     *            int firstNeighbor = map.iterator().next();
     * */
    public boolean isBipartite(int n, int[][] dislikes) {
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

    private int[] parent;

    public int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[parentB] = parentA;
    }

}