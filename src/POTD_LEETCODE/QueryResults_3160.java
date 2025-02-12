package POTD_LEETCODE;

import java.util.HashMap;

class QueryResults_3160 {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> balls = new HashMap<>();
        HashMap<Integer, Integer> colours = new HashMap<>();

        int count = 0;
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int b = queries[i][0], c = queries[i][1];

            if (balls.containsKey(b)) {
                int prevC = balls.get(b);
                int val = colours.merge(prevC, -1, Integer::sum);// this colour count in decreased
                if (val == 0) colours.remove(prevC);
            }
            balls.put(b, c);
            colours.merge(c, 1, Integer::sum);
            ans[i] = colours.size();
        }
        return ans;
    }

    public int[] queryResults2(int limit, int[][] queries) {
        HashMap<Integer, Integer> balls = new HashMap<>();
        HashMap<Integer, Integer> colours = new HashMap<>();

        int count = 0;
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int b = queries[i][0], c = queries[i][1];

            if (balls.containsKey(b)) {
                int prevC = balls.get(b);
                int val = colours.merge(prevC, -1, Integer::sum);// this colour count in decreased
                if (val == 0) count--;
            }
            balls.put(b, c);
            int val = colours.merge(c, 1, Integer::sum);
            if (val == 1) count++;
            ans[i] = count;
        }
        return ans;
    }

    public int[] queryResults3(int limit, int[][] queries) {
        int count = 0;
        int n = queries.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> balls = new HashMap<>(n * 4 / 3 + 1);
        HashMap<Integer, Integer> colours = new HashMap<>(n * 4 / 3 + 1);

        for (int i = 0; i < n; i++) {
            int b = queries[i][0], c = queries[i][1];

            if (balls.containsKey(b)) {
                int prevC = balls.get(b);
                int val = colours.merge(prevC, -1, Integer::sum);// this colour count in decreased
                if (val == 0) count--;
            }
            balls.put(b, c);
            int val = colours.merge(c, 1, Integer::sum);
            if (val == 1) count++;
            ans[i] = count;
        }
        return ans;//
    }
}