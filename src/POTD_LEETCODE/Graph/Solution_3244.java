package POTD_LEETCODE.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class Solution_3244 {
    public static void main(String[] args) {
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] ans = shortestDistanceAfterQueries(5, queries);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(i);

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            remove(set, first, second);
            ans[i] = set.size() - 1;
        }
        return ans;
    }

    private static void remove(TreeSet<Integer> set, Integer first, Integer second) {
//        set.removeAll(new ArrayList<>(set.subSet(first, true, second, false)));
//        new ArrayList<>(set.subSet(first + 1, second)).forEach(set::remove);
        set.removeAll(new ArrayList<>(set.subSet(first + 1, second)));
    }
}