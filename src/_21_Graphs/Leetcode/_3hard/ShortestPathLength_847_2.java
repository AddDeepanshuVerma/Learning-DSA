package _21_Graphs.Leetcode._3hard;

//26 / 54 testcases passed
class ShortestPathLength_847_2 {
    int len;
    private int nv;
    private int max;

    public int shortestPathLength(int[][] graph) {
        len = Integer.MAX_VALUE;
        nv = graph.length;
        max = 0;
        for (int[] arr : graph) max = Math.max(max, arr.length);

        int[] visited;
        for (int i = 0; i < nv; i++) {
            visited = new int[nv + 1];
            visited[i]++;
            dfs(i, 0, visited, graph);
        }
        return len;
    }

    private void dfs(int curr, int move, int[] visited, int[][] graph) {
        if (visitedNodes(visited) == nv) {
            len = Math.min(len, move);
            return;
        }

        for (int v : graph[curr]) {
            if (visited[v] < max) {
                visited[v]++;
                dfs(v, move + 1, visited, graph);
                visited[v]--;
            }
        }
    }

    private int visitedNodes(int[] visited) {
        int count = 0;
        for (int val : visited) {
            if (val > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847_2();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}