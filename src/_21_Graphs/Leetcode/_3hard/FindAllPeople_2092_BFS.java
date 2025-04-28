package _21_Graphs.Leetcode._3hard;

import java.util.*;

class FindAllPeople_2092_BFS {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // u -> {v,w}
        for (int[] meeting : meetings) {
            int u = meeting[0], v = meeting[1], t = meeting[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, t});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // stores {time, node}
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        int[] max = new int[n];
        Arrays.fill(max, Integer.MAX_VALUE);
        max[0] = 0;
        max[firstPerson] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int ut = poll[0];
            int u = poll[1];
            if (max[u] < ut) continue; // better time was already achieved earlier

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0];
                int vt = ngbr[1];
                // next neighbour time has to be more or equal to spread the secret
                // also the new time should be lower than earlier time needed to spread till this new node
                if (ut <= vt && vt < max[v]) {
                    max[v] = vt;
                    pq.offer(new int[]{vt, v});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < max.length; i++) {
            if (max[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}