package POTD_LEETCODE.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class MaxKDivisibleComponents_2872 {
    int componentsCount = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        /*
         * First we need to calculate the neighbours of all the elements
         * lets put that in a Hashmap of (element, List<>Its elements)
         * now we need to make a DFS where our moto is :
         *   1. Reach to the last element possible where we don't go back to the previous element
         *   2. now after base condition get hit(or in this case, not further neighbours are there)
         *   3. we'll check what is the sum of curr element,
         *       if it is divisible by k then this element itself can be a separate component
         *       else is sum will be sent to its previous element where it was called and will be added to that element value
         *       where the condition get applied of ~ divisible by k then component++
         * */

        HashMap<Integer, List<Integer>> ngbrs = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0], second = edge[1];
            ngbrs.computeIfAbsent(first, val -> new ArrayList<Integer>()).add(second);
            ngbrs.computeIfAbsent(second, val -> new ArrayList<Integer>()).add(first);
        }

        // now we can start our DFS with any node we want, lets start with 0 here
        int curr = 0, prev = -1;
        dfs(curr, prev, ngbrs, values, k);
        return componentsCount;
    }

    private long dfs(int curr, int prev, HashMap<Integer, List<Integer>> ngbrs, int[] values, int k) {
        // sum of current element
        long sum = values[curr];
        for (int ngbr : ngbrs.getOrDefault(curr, Collections.emptyList())) {
            if (ngbr == prev) continue;
            sum += dfs(ngbr, curr, ngbrs, values, k);
        }

        // is this sum is divisible by k then it makes in component
        if (sum % k == 0) {
            componentsCount++;
            sum = 0;
        }
        return sum;
    }
}