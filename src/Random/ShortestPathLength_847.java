package Random;

import java.util.ArrayDeque;

// most optimal so far : Used bitMasking to  track visited path for each individual node & hence a common HashSet for all nodes
class ShortestPathLength_847 {
    public int shortestPathLength(int[][] graph) {
        int nv = graph.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nv; i++) {
            min = Math.min(min, dfs(graph, i));
        }
        return min;
    }

    private int dfs(int[][] graph, int node) {
        int nv = graph.length;
        int dst = (1 << nv) - 1;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{node, 1 << node});

        boolean[][] visited = new boolean[nv + 1][((1 << nv) - 1) + 1];
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] poll = q.poll();
                int u = poll[0];
                int uMask = poll[1];
                if (uMask == dst) return level;

                for (int v : graph[u]) {
                    int vMask = uMask | (1 << v);
                    if (!visited[v][vMask]) {
                        visited[v][vMask] = true;
                        q.offer(new int[]{v, vMask});
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847();
//        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
//        int[][] graph = {{1, 2}, {0, 2}, {0, 1}};
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}