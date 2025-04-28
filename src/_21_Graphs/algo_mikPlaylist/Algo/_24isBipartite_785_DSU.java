package _21_Graphs.algo_mikPlaylist.Algo;

import jdk.jfr.Description;

@Description("Using one -> many relationship graph structure")
class _24isBipartite_785_DSU {
    /*
     * KeyPoints
     * if we can go to 5 node from a single node, then we will put all those 5 destination node in same component
     * while doing this if we found out that single node was with any of these find node as per earlier doings then
     * it's a clash and graph is not bipartite
     * NOTE : We could apply this when we knew that we have one -> many relationship
     * */

    public boolean isBipartite(int[][] graph) {
        int nv = graph.length;
        parent = new int[nv];
        for (int i = 0; i < nv; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int u = i;
                int v = graph[i][j];
                if (find(u) == find(v)) return false; // checking if u,v of an edge are in same component which they shouldn't

                // We union all the neighbors together (first neighbor getting together to all other ones)
                // int firstNeighbour = graph[i][0]
                union(graph[i][0], v);
            }
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