package POTD_LEETCODE.Graph;

import java.util.*;

class Solution_3243 {
    public static void main(String[] args) {
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] ans = shortestDistanceAfterQueries(5, queries);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
//            map.computeIfAbsent(i, val -> new ArrayList<>()).add(i + 1);
            map.put(i, new ArrayList<>(List.of(i + 1)));
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            // First need to add path added
            map.computeIfAbsent(queries[i][0], val -> new ArrayList<>()).add(queries[i][1]);
            ans[i] = BFS(map, n - 1); // if return value is 1, simply fill remaining elements of array with 1 only
            /*if (ans[i] <= 1) {
                int val = ans[i];
                while (++i < m) ans[i] = val;
                break;
            }*/ // doesn't affect on thrown testCases
        }
        return ans;
    }

    private static int BFS(HashMap<Integer, List<Integer>> map, int dest) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int pop = q.removeFirst();
                if (pop == dest) return depth;
                for (Integer val : map.get(pop)) {
                    q.addLast(val);
                }
            }
            depth++;
        }
        return depth;
    }
}