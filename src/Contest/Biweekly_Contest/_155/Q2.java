package Contest.Biweekly_Contest._155;

import java.util.*;

public class Q2 {

    public int[] baseUnitConversions(int[][] conversions) {
        final int MOD = (int) (1e9 + 7);
        int nv = conversions.length + 1;
        int[] indegree = new int[nv];

        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : conversions) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            indegree[v]++;
        }

        int[] multiple = new int[nv];
        Arrays.fill(multiple, 1);
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offerLast(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], w = ngbr[1];
                multiple[v] *= multiple[u] * w;
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return multiple;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();

    }
}
