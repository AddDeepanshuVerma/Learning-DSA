package _21_Graphs.Leetcode._3hard;

import java.util.*;

class LargestPathValue_1857 {
    public int largestPathValue(String colors, int[][] edges) {
        char[] color = colors.toCharArray();
        int nv = color.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[nv];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        int exploredNodes = 0;
        int[][] t = new int[nv][26]; // stores max for nv node, max number of occurance of any alphabets
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int node = 0; node < indegree.length; node++) {
            if (indegree[node] == 0) {
                q.offer(node);
                t[node][color[node] - 'a'] = 1;
                exploredNodes++;
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int u = q.pop();
            ans = Math.max(ans, t[u][color[u] - 'a']);

            for (int v : map.getOrDefault(u, Collections.emptyList())) {
                for (int i = 0; i < 26; i++) {
                    t[v][i] = Math.max(t[v][i], t[u][i] + (i == (color[v] - 'a') ? 1 : 0));
                }
                if (--indegree[v] == 0) {
                    q.offer(v);
                    exploredNodes++;
                }
            }
        }
        return exploredNodes == nv ? ans : -1;
    }
}