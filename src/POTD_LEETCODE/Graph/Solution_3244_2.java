package POTD_LEETCODE.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class Solution_3244_2 {
    public static void main(String[] args) {
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] ans = shortestDistanceAfterQueries(5, queries);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(i);

        int m = queries.length, i = 0;
        int[] ans = new int[m];

        for (int[] query : queries) {
            new ArrayList<>(set.subSet(query[0] + 1, query[1])).forEach(set::remove);
            ans[i++] = set.size() - 1;
        }

        return ans;
    }
}