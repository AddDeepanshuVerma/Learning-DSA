package POTD_LEETCODE.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class MaxKDivisibleComponents_2872_compact {
    int componentsCount = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        HashMap<Integer, List<Integer>> ngbrs = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0], second = edge[1];
            ngbrs.computeIfAbsent(first, val -> new ArrayList<Integer>()).add(second);
            ngbrs.computeIfAbsent(second, val -> new ArrayList<Integer>()).add(first);
        }

        int curr = 0, prev = -1;
        dfs(curr, prev, ngbrs, values, k);
        return componentsCount;
    }

    private long dfs(int curr, int prev, HashMap<Integer, List<Integer>> ngbrs, int[] values, int k) {
        long sum = values[curr];
        for (int ngbr : ngbrs.getOrDefault(curr, Collections.emptyList())) {
            if (ngbr == prev) continue;
            sum += dfs(ngbr, curr, ngbrs, values, k);
        }

        if (sum % k == 0) componentsCount++;
        return sum;
    }
}