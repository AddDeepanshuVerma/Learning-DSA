package Contest.Biweekly_Contest._155;

import java.util.*;

public class Q4 {

    public int maxProfit(int n, int[][] edges, int[] score) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // stores {nodes, it's score} // the lowest score need to pop first
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                pq.offer(new int[]{i, score[i]});
            }
        }

        int multipler = 1;
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], uScore = poll[1];
            ans += uScore * multipler++;

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    pq.offer(new int[]{v, score[v]});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q4 obj = new Q4();

        int n = 5;
        int[][] edges = {{1, 2}, {0, 3}, {1, 4}, {2, 3}, {1, 3}};
        int[] score = {50913, 47946, 97391, 27488, 69147};

        int ans = obj.maxProfit(n, edges, score);
        System.out.println("ans = " + ans);
    }
}
