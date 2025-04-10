package _21_Graphs.Leetcode._3hard;

import java.util.ArrayDeque;
import java.util.HashSet;

// most optimal so far : Used bitMasking to  track visited path for each individual node & hence a common HashSet for all nodes
class ShortestPathLength_847_optimal {
    public int shortestPathLength(int[][] graph) {
        int nv = graph.length;
        int dst = (1 << nv) - 1;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < nv; i++) {
            q.offer(new Pair(i, 1 << i));
        }

        HashSet<Pair> visited = new HashSet<>();
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair poll = q.poll();
                int u = poll.node;
                int uMask = poll.mask;
                if (uMask == dst) return level;

                for (int v : graph[u]) {
                    int vMask = uMask | (1 << v);
                    if (!visited.contains(new Pair(v, vMask))) {
                        visited.add(new Pair(v, vMask));
                        q.offer(new Pair(v, vMask));
                    }
                }
            }
            level++;
        }

        return -1;
    }

    record Pair(Integer node, Integer mask) {

    }


    public static void main(String[] args) {
        var obj = new ShortestPathLength_847_optimal();
//        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
//        int[][] graph = {{1, 2}, {0, 2}, {0, 1}};
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}