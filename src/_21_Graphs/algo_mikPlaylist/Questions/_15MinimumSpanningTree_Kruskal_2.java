package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.List;
import java.util.PriorityQueue;

public class _15MinimumSpanningTree_Kruskal_2 {
    static int Kruskal_Algorithm(int V, int E, List<List<int[]>> adj) {
        parent = new int[V];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {u,v,w}

        for (int u = 0; u < adj.size(); u++) {
            for (int[] pair : adj.get(u)) {
                int v = pair[0];
                int w = pair[1];
                pq.offer(new int[]{u, v, w});
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], v = poll[1], w = poll[2];

            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                sum += w;
                union(u, v);
            }
        }
        return sum;
    }

    static int[] parent;

    static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    static void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);
        if (uParent != vParent) {
            parent[uParent] = vParent;
        }
    }

}
