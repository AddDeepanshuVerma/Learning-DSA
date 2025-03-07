package _21_Graphs.Leetcode;

import java.util.*;

class _22MinimumDiameterAfterMerge_3203_2 {
    public static void main(String[] args) {
        int ans = minimumDiameterAfterMerge(new int[0][], new int[0][]);
        System.out.println("ans = " + ans);
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = TreeDiameterLength(generateGraph(edges1));
        int diameter2 = TreeDiameterLength(generateGraph(edges2));

        int combinedMinimum = 1 + ((diameter1 + 1) / 2) + ((diameter2 + 1) / 2);
        return Math.max(combinedMinimum, Math.max(diameter1, diameter2));
    }

    private static int TreeDiameterLength(HashMap<Integer, List<Integer>> graph) {
        int[] info1 = farthestNode_bfs(0, graph); // info = {the farthest node, count of edges till the farthest node}
        int[] info2 = farthestNode_bfs(info1[0], graph);
        return info2[1];
    }

    private static int[] farthestNode_bfs(int source, HashMap<Integer, List<Integer>> graph) {
        HashSet<Integer> seen = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(source);
        seen.add(source);
        int nodeCount = 0, farthestNode = source;

        while (!q.isEmpty()) {
            int size = q.size();
            nodeCount++;

            while (size-- > 0) {
                int u = q.poll();
                farthestNode = u;

                for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                    if (seen.contains(v)) continue;
                    seen.add(v);
                    q.offer(v);
                }
            }
        }
        return new int[]{farthestNode, nodeCount - 1};
    }

    private static HashMap<Integer, List<Integer>> generateGraph(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        return graph;
    }
}