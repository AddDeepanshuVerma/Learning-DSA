package _21_Graphs.Leetcode._2medium;

import java.util.*;

class ClosestMeetingNode_2359_2 {

    private HashMap<Integer, List<Integer>> adj;

    public int closestMeetingNode(int[] edges, int n1, int n2) {
        int nv = edges.length;
        adj = new HashMap<>();
        for (int u = 0; u < edges.length; u++) {
            int v = edges[u];
            if (v != -1) {
                adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            }
        }
        // we will do bfs from both end 1 by 1 & store values in below manner
        // {in 0 second, {n1, n2}} === in 0 second we can go to n1 and n2
        // hence whenever starting from 0 till end seconds the first value where n1 == n2 is our first clash
        int[] reach1 = bfs(n1, nv);
        int[] reach2 = bfs(n2, nv);
        System.out.println(Arrays.toString(reach1));
        System.out.println(Arrays.toString(reach2));

        int min = Integer.MAX_VALUE;
        int resNode = -1;
        for (int node = 0; node < reach1.length; node++) {
            if (reach1[node] != -1 && reach2[node] != -1) {
                // means both are reaching to this node
                int max = Math.max(reach1[node], reach2[node]);
                if (max < min) {
                    min = max;
                    resNode = node;
                }
            }
        }
        return resNode;
    }

    private int[] bfs(int src, int nv) {
        int[] visited = new int[nv];
        Arrays.fill(visited, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(src);
        int time = 0;
        visited[src] = time;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                int u = q.removeFirst();
                for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (visited[v] != -1) {
                        visited[v] = time;
                        q.addLast(v);
                    }
                }
            }
        }
        return visited;
    }
}