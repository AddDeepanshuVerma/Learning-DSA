package _21_Graphs.Leetcode._3hard;

import java.util.*;

//synced with 1-n nodes though makes it complex & unnecessary doing
class MinimumTime_2050_2 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] relation : relations) {
            adj.computeIfAbsent(relation[0], list -> new ArrayList<>()).add(relation[1]);
            indegree[relation[1] - 1]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i + 1);
            }
        }

        int[] max = new int[n];
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int u = q.poll();
            ans = Math.max(ans, time[u - 1]);// store the max so far

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                max[v - 1] = Math.max(max[v - 1], time[u - 1]);
                indegree[v - 1]--;
                if (indegree[v - 1] == 0) {
                    max[v - 1] += time[v - 1];
                    time[v - 1] = max[v - 1];
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
        var obj = new MinimumTime_2050_2();
        int ans = obj.minimumTime(n, relations, time);
        System.out.println("ans = " + ans);
    }
}