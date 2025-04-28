package _21_Graphs.Leetcode._3hard;

import java.util.ArrayDeque;
import java.util.HashSet;

//40 / 54 testcases passed :::Similar to previous but with a single BFS approach, can be called as MultiSourceBFS
class ShortestPathLength_847_5 {
    public int shortestPathLength(int[][] graph) {
        return bfs(graph.length, graph);
    }

    private int bfs(int nv, int[][] graph) {
        ArrayDeque<Trio> q = new ArrayDeque<>();

        for (int i = 0; i < nv; i++) {
            HashSet<String> visited = new HashSet<>();
            HashSet<Integer> distinct = new HashSet<>();
            distinct.add(i);
            q.offer(new Trio(i, visited, distinct));
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Trio poll = q.poll();
                int u = poll.node;
                HashSet<String> vis = poll.visited;
                HashSet<Integer> dis = poll.distinct;
                if (dis.size() == graph.length) { // found the answer
                    return level;
                }

                for (int v : graph[u]) {
                    String key = u + "_" + v;
                    if (!vis.contains(key)) {
                        HashSet<String> newVis = new HashSet<>(vis);
                        HashSet<Integer> newDis = new HashSet<>(dis);
                        newVis.add(key);
                        newDis.add(v);
                        q.offer(new Trio(v, newVis, newDis));
                    }
                }

            }
            level++;
        }
        return Integer.MAX_VALUE;
    }

    record Trio(Integer node, HashSet<String> visited, HashSet<Integer> distinct) {
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847_5();
//        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
//        int[][] graph = {{1, 2}, {0, 2}, {0, 1}};
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}