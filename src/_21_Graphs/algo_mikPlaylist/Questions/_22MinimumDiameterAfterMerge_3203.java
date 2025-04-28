package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class _22MinimumDiameterAfterMerge_3203 {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = TreeDiameterLength(edges1);
        int diameter2 = TreeDiameterLength(edges2);

        int combinedMinimum = 1 + ((diameter1 + 1) / 2) + ((diameter2 + 1) / 2);
        return Math.max(combinedMinimum, Math.max(diameter1, diameter2));
    }

    private int TreeDiameterLength(int[][] edges) {
        if (edges.length == 0) return 0; //corner case

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        int[] info1 = farthestNode_bfs(0, graph); // info = { fastest node, count of edges till the farthest node}
        int[] info2 = farthestNode_bfs(info1[0], graph);
        return info2[1];
    }


    private static int[] farthestNode_bfs(int start, HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int nodeCount = 0, lastNode = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            nodeCount++;

            while (size-- > 0) {
                int u = q.poll();
                lastNode = u;

                for (int v : graph.get(u)) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return new int[]{lastNode, nodeCount - 1};
    }
}