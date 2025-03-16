package _21_Graphs.Leetcode._2medium;

import java.util.*;

class ClosestMeetingNode_2359 {

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

        boolean[] v1 = new boolean[nv], v2 = new boolean[nv];
        ArrayDeque<int[]> q = new ArrayDeque<>(); // stores node and their visited array name {node, 1}
        q.addLast(new int[]{n1, 1});
        q.addLast(new int[]{n2, 2});
        v1[n1] = true;
        v2[n2] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pair = q.removeFirst();
                int u = pair[0], vis = pair[1];
                if (vis == 1) {
                    if (v2[u]) {
                        return u; // found first clash
                    }
                    for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                        if (v1[v]) continue;
                        v1[v] = true;
                        q.addLast(new int[]{v, vis});
                    }
                } else {
                    if (v1[u]) {
                        return u; // found first clash
                    }
                    for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                        if (v2[v]) continue;
                        v2[v] = true;
                        q.add(new int[]{v, vis});
                    }
                }
            }
        }
        return -1;
    }
}