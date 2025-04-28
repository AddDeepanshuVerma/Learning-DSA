package _21_Graphs.Leetcode._3hard;

//26 / 54 testcases passed
class ShortestPathLength_847_3 {
    int len;
    private int nv;
    private int max;
    private int count;

    public int shortestPathLength(int[][] graph) {
        len = Integer.MAX_VALUE;
        nv = graph.length;
        count = 0;
        max = 0;
        for (int[] arr : graph) max = Math.max(max, arr.length);

        int[] visited;
        for (int i = 0; i < nv; i++) {
            visited = new int[nv + 1];
            visited[i]++;
            count = 1;
            dfs(i, 0, visited, graph);
            count = 0;
        }
        return len;
    }

    private void dfs(int curr, int move, int[] visited, int[][] graph) {
        if (count == nv) {
            len = Math.min(len, move);
            return;
        }

        for (int v : graph[curr]) {
            if (visited[v] < max) {
                if (++visited[v] == 1) count++;
                dfs(v, move + 1, visited, graph);
                if (--visited[v] == 0) count--;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847_3();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}