package _21_Graphs.Algo_MikePlayList;

import java.util.Arrays;

public class _19Kruskal_Algorithm {
    /*
     * DEF: Used to get the sum of minimum spanning tree (Kruskal Algorithm === weight sorted edges + DSU)
     * Kruskal's algorithm is designed for undirected graphs. It does not work for directed graphs
     * How:
     * 1. We arrange all the given edges in following manner : List of {u, v, w} and sort them based on weight to process low w first.
     * 2. Now we will take those min weights out 1 by 1 and if they do not belong to same component, union them & add its w in sum
     * 3. if they already belong to same component then this edge will be of higher W value and is getting repeated hence ignore.
     * 4. To put them in same component we are going to use DSU union & find algo
     * */
    private static int sumOfMinimumSpanningTree(int V, int E, int[][] edges) {
        parent = new int[V];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]); // to sort the edge based on lower weight edge first

        int sum = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], W = edge[2];
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) { // for UDG we can also(not needed) put another check: (u < v && ) to not process same edge 2 time
                sum += W;
                union(u, v);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        int[][] edges = {{0, 1, 2}, {1, 2, 3}, {2, 0, 10}}; // {u,v,w}
        int sum = sumOfMinimumSpanningTree(V, E, edges);
        System.out.println("sum = " + sum);
    }

    static int[] parent;

    static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

}
