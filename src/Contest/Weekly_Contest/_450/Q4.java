package Contest.Weekly_Contest._450;

import java.util.*;

public class Q4 {
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] query : queries) {
            int u = query[0], v = query[1], w = query[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        return null;
    }

}
