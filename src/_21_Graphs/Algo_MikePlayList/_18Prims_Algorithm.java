package _21_Graphs.Algo_MikePlayList;

import java.util.*;

public class _18Prims_Algorithm {
    public static void main(String[] args) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        // adj contains {0, {{1,2}, {2, 5}}... so on
        System.out.println(prims_Algorithm(5, 7, adj));
    }

    static int prims_Algorithm(int V, int E, HashMap<Integer, List<Pair>> adj) {
        int nv = adj.size();
        PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight); //{weight, currNode}
        boolean[] InMST = new boolean[nv];
        int[] parent = new int[nv];
        Arrays.fill(parent, -1);

        pq.offer(new Trio(0, 0, -1)); // initially parent of added node, let === -1
        int sum = 0;

        while (!pq.isEmpty()) {
            Trio poll = pq.poll();
            int w = poll.weight;
            int u = poll.node;
            int p = poll.parent;

            if (InMST[u]) continue; // if this node is already in our MST then a better edge must have added so ignore this one
            InMST[u] = true;
            sum += w;

            parent[u] = p;

            for (Pair pair : adj.getOrDefault(u, Collections.emptyList())) {
                int vW = pair.weight;
                int v = pair.node;
                if (!InMST[v]) { // [0] refers to node
                    pq.offer(new Trio(vW, v, u));
                }
            }
        }
        return sum;
    }

    record Pair(Integer node, Integer weight) {
    }

    record Trio(Integer node, Integer weight, Integer parent) {
    }
}
