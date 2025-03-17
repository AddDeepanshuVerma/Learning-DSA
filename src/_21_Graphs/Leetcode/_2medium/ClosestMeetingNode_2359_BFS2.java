package _21_Graphs.Leetcode._2medium;

import java.util.*;

// Passes all testCase with Higher TC: (V+E) + (V+E)... their lies an optimal approach
class ClosestMeetingNode_2359_BFS2 {

    public int closestMeetingNode(int[] edges, int n1, int n2) {
        int[] reach1 = bfs(n1, edges);
        int[] reach2 = bfs(n2, edges);
        System.out.println("reach1 = " + Arrays.toString(reach1));
        System.out.println("reach2 = " + Arrays.toString(reach2));

        int min = Integer.MAX_VALUE;
        int resNode = -1;
        for (int i = 0; i < reach1.length; i++) {
            int max = Math.max(reach1[i], reach2[i]);
            if (max < min) {
                min = max;
                resNode = i;
            }
        }
        return resNode;
    }

    private int[] bfs(int src, int[] edges) {
        int[] visited = new int[edges.length];
        Arrays.fill(visited, Integer.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(src);
        visited[src] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.removeFirst();
                int v = edges[u];
                if (v == -1 || visited[v] != Integer.MAX_VALUE) continue; // no valid next node or next node is already visited
                visited[v] = 1 + visited[u];
                q.addLast(v);
            }
        }
        return visited;
    }
}