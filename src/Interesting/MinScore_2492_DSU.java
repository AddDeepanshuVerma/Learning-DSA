package Interesting;

class MinScore_2492_DSU {
    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            int uParent = find(u);
            int vParent = find(v);

            parent[vParent] = uParent;
        }

        // now we have simply divided them in components & we know that src:1 & dst:n belongs to same component
        // hence simply traverse again and store minimum distance of those nodes which are in same component with src or distance, any one
        int src = 1;
        int ans = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int u = road[0], v = road[1], d = road[2];
            if (find(u) == find(src)) {
                ans = Math.min(ans, d);
            }
        }
        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{1, 3, 1484}, {3, 2, 3876}, {2, 4, 6823}, {6, 7, 579}, {5, 6, 4436}, {4, 5, 8830}};
        var obj = new MinScore_2492_DSU();
        System.out.println(obj.minScore(n, roads));
    }
}