package _21_Graphs.Leetcode._3hard;

import java.util.*;

class MinimumTime_2050_3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n + 1];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] relation : relations) {
            adj.computeIfAbsent(relation[0], list -> new ArrayList<>()).add(relation[1]);
            indegree[relation[1]]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] max = new int[n + 1];
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int u = q.poll();
            ans = Math.max(ans, time[u - 1]);// store the max so far

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                max[v] = Math.max(max[v], time[u - 1]);
                indegree[v]--;
                if (indegree[v] == 0) {
                    max[v] += time[v - 1];
                    time[v - 1] = max[v];
                    q.offer(v);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relations = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time = {1, 2, 3, 4, 5};
        var obj = new MinimumTime_2050_3();
        int ans = obj.minimumTime(n, relations, time);
        System.out.println("ans = " + ans);
    }
}