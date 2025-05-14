package Contest.Weekly_Contest._449;

import java.util.*;

class MaxScore_3547_2 {

    int N;
    int[] parent;

    int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);

        parent[bParent] = aParent;
    }

    public long maxScore(int n, int[][] edges) {
        N = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            union(u, v);
        }

        HashMap<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            components.computeIfAbsent(find(i), list -> new ArrayList<>()).add(i);
        }

        HashMap<Integer, Boolean> compCycle = new HashMap<>(); // stores if component leader has cycle or not
        outer:
        for (var item : components.entrySet()) {
            int leader = item.getKey();
            int degreeCount = 0;
            for (Integer vertex : item.getValue()) {
                if (degree[vertex] != 2) {
                    compCycle.put(leader, false);
                    continue outer;
                }
            }
            compCycle.put(leader, true);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (compCycle.get(a).equals(true) && compCycle.get(b).equals(true)) {
                return components.get(b).size() - components.get(a).size();
            } else if (compCycle.get(a).equals(true) || compCycle.get(b).equals(true)) {
                return compCycle.get(a).equals(true) ? -1 : 1;
            } else {
                return components.get(b).size() - components.get(a).size();
            }
        });
        for (Integer key : components.keySet()) {
            pq.offer(key);
        }

        long count = 0;
        HashMap<Integer, Integer> assign = new HashMap<>();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            count += assignNumbers(assign, u, components.get(u), compCycle.get(u));
        }

        return count;
    }

    private long assignNumbers(HashMap<Integer, Integer> assign, int leader, List<Integer> components, Boolean isCycle) {
        long count = 0;
        int val = N;
        long[] arr = new long[components.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = val--;
        }

        // count even indexes
        for (int i = 0; i < arr.length; i += 2) {
            if (i + 2 < arr.length) {
                count += (long) arr[i] * arr[i + 2];
            }
        }
        // count odd indexes
        for (int i = 1; i < arr.length; i += 2) {
            if (i + 2 < arr.length) {
                count += arr[i] * arr[i + 2];
            }
        }
        // now add first two values
        if (arr.length >= 2) {
            count += arr[0] * arr[1];
        }
        if (isCycle && arr.length > 2) {
            count += arr[arr.length - 1] * arr[arr.length - 2];
        }

        N -= arr.length;
        return count;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 6}};
        var obj = new MaxScore_3547_2();
        long ans = obj.maxScore(n, edges);
        System.out.println("ans = " + ans);

        n = 6;
        edges = new int[][]{{0, 3}, {4, 5}, {2, 0}, {1, 3}, {2, 4}, {1, 5}};
        ans = obj.maxScore(n, edges);
        System.out.println("ans = " + ans);
    }
}