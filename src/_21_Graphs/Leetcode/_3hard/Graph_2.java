package _21_Graphs.Leetcode._3hard;

import java.util.*;

//BellMan Ford Algorithm : 100 * V * E
class Graph_2 {
    private final List<int[]> order;
    int nv;

    public Graph_2(int n, int[][] edges) {
        nv = n;
        order = new ArrayList<>();
        for (int[] edge : edges) {
            order.add(new int[]{edge[0], edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        order.add(new int[]{edge[0], edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        return bellManFord(node1, node2);
    }

    private int bellManFord(int src, int dst) {
        int[] distance = new int[nv];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < nv; i++) { // need to relax edges v-1 times
            for (int[] arr : order) {
                int u = arr[0], v = arr[1], w = arr[2];
                if (distance[u] == Integer.MAX_VALUE) continue;

                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

}