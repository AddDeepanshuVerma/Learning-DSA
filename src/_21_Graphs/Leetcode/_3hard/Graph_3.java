package _21_Graphs.Leetcode._3hard;

import java.util.Arrays;

//Floyd Warshall : 100 * V * V * V
class Graph_3 {
    int nv;
    private final int[][] mat;

    public Graph_3(int n, int[][] edges) {
        nv = n;
        mat = new int[nv][nv];
        for (int[] m : mat) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            mat[edge[0]][edge[1]] = edge[2];
        }
    }

    public void addEdge(int[] edge) {
        mat[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        return floydWarshallAlgo(node1, node2);
    }

    public int floydWarshallAlgo(int src, int dst) {
        for (int i = 0; i < nv; i++)
            for (int j = 0; j < nv; j++) {
                if (i == j) {
                    mat[i][j] = 0;// from same node or same node, we can reach in no time hence 0
                }
            }

        for (int k = 0; k < nv; k++) {
            for (int i = 0; i < nv; i++) {
                for (int j = 0; j < nv; j++) {
                    if (mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE) continue;
                    if (mat[i][k] + mat[k][j] < mat[i][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }

        return mat[src][dst] == Integer.MAX_VALUE ? -1 : mat[src][dst];
    }

}