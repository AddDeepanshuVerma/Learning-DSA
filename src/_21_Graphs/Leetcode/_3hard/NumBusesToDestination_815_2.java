package _21_Graphs.Leetcode._3hard;

import java.util.*;

class NumBusesToDestination_815_2 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;                          // edge case

        List<HashSet<Integer>> map = new ArrayList<>();
        HashSet<Integer> src = new HashSet<>();
        HashSet<Integer> dst = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            map.add(new HashSet<>());
            for (int route : routes[i]) {
                map.get(i).add(route);
            }
            if (map.get(i).contains(source)) src.add(i);
            if (map.get(i).contains(target)) dst.add(i);
        }
        if (!Collections.disjoint(src, dst)) {                  // edge case
            return 1; // if source and destination belongs to same route then simply return 1
        }

        // now we need to make a graph of route to route
        HashMap<Integer, List<Integer>> adj = new HashMap<>(); // route -> route mapping which obviously takes 1 cost

        for (int i = 0; i < map.size(); i++) {
            HashSet<Integer> set1 = map.get(i);
            for (int j = i + 1; j < map.size(); j++) {
                HashSet<Integer> set2 = map.get(j);
                if (!Collections.disjoint(set1, set2)) {
                    adj.computeIfAbsent(i, list -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, list -> new ArrayList<>()).add(i);
                }
            }
        }

        // now simply do a BFS to find source from target where each edge costs 1
        return bfs(src, dst, adj);
    }

    private static int bfs(HashSet<Integer> sources, HashSet<Integer> destinations, HashMap<Integer, List<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (Integer src : sources) {
            q.offer(src);
            visited.add(src);
        }

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int u = q.poll();
                if (destinations.contains(u)) return level;

                for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{0, 1, 6, 16, 22, 23}, {14, 15, 24, 32}, {4, 10, 12, 20, 24, 28, 33}, {1, 10, 11, 19, 27, 33}, {11, 23, 25, 28}, {15, 20, 21, 23, 29},
                {29}};
        int ans = numBusesToDestination(routes, 4, 21);
        System.out.println("ans = " + ans);
    }

}