package _21_Graphs.Leetcode._5revision;

class FindChampion_2924 {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[v]++;
        }

        int count = 0;
        int node = -1;

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                node = i;
                count++;
                if (count > 1) return -1; // more than one weak node
            }
        }
        return node;
    }

    public int findChampion2(int n, int[][] edges) {
        boolean[] weak = new boolean[n];

        for (int[] edge : edges) {
            weak[edge[1]] = true;
        }

        int count = 0;
        int node = -1;
        for (int i = 0; i < weak.length; i++) {
            if (!weak[i]) {
                if (++count > 1) return -1;
                node = i;
            }
        }
        return node;
    }
}