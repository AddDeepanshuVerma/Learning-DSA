package Contest.Weekly_Contest._449;

import java.util.*;

class MaxScore_3547_3 {
    int N;
    int[] parent;

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
        for (var item : components.entrySet()) {
            compCycle.put(item.getKey(), hasEvenDegree(item.getValue(), degree));
        }

        Comparator<Integer> comp = (a, b) -> {
            if (compCycle.get(a) || compCycle.get(b)) {
                return compCycle.get(a).equals(true) ? -1 : 1;
            } else {
                return components.get(b).size() - components.get(a).size();
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.addAll(components.keySet());

        long count = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll();
            count += assignNumbers(u, components.get(u), compCycle.get(u));
        }

        return count;
    }

    private boolean hasEvenDegree(List<Integer> list, int[] degree) {
        for (int val : list) {
            if (degree[val] != 2) {
                return false;
            }
        }
        return true;
    }

    private long assignNumbers(int leader, List<Integer> components, Boolean isCycle) {
        int val = N, size = components.size();
        long count = 0;
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) arr[i] = val--;

        // count even indexes
        for (int i = 0; i < size; i += 2) {
            if (i + 2 < size) {
                count += arr[i] * arr[i + 2];
            }
        }
        // count odd indexes
        for (int i = 1; i < size; i += 2) {
            if (i + 2 < size) {
                count += arr[i] * arr[i + 2];
            }
        }
        // now add first two values
        if (size >= 2) {
            count += arr[0] * arr[1];
        }
        if (isCycle && size > 2) {
            count += arr[size - 1] * arr[size - 2];
        }

        N -= size;
        return count;
    }

    int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);

        parent[bParent] = aParent;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 6}};
        var obj = new MaxScore_3547_3();
        long ans = obj.maxScore(n, edges);
        System.out.println("ans = " + ans);

        n = 6;
        edges = new int[][]{{0, 3}, {4, 5}, {2, 0}, {1, 3}, {2, 4}, {1, 5}};
        ans = obj.maxScore(n, edges);
        System.out.println("ans = " + ans);
    }
}