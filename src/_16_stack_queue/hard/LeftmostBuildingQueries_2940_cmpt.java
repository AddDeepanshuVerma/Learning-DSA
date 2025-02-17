package _16_stack_queue.hard;

import java.util.*;

class LeftmostBuildingQueries_2940_cmpt {
    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        int[] ans = leftmostBuildingQueries(heights, queries);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        HashMap<Integer, List<Pair>> map = new HashMap<>(); //{maxIndex of query -> {maxValue, queryIdx}}
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < queries.length; i++) {
            int maxIdx = Math.max(queries[i][0], queries[i][1]);
            int minIdx = Math.min(queries[i][0], queries[i][1]);
            int maxValue = Math.max(heights[minIdx], heights[maxIdx]);

            if (minIdx == maxIdx) {
                ans[i] = minIdx;
            } else if (heights[maxIdx] > heights[minIdx]) {
                ans[i] = maxIdx;
            } else {
                map.computeIfAbsent(maxIdx, val -> new ArrayList<>()).add(new Pair(maxValue, i));
            }
        }

        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.maxValue - b.maxValue);
        for (int i = 0; i < heights.length; i++) {
            que.addAll(map.getOrDefault(i, Collections.emptyList()));
            while (!que.isEmpty() && heights[i] > que.peek().maxValue) {
                Pair poll = que.poll();
                ans[poll.queryIdx] = i;
            }
        }
        return ans;
    }

    record Pair(Integer maxValue, Integer queryIdx) {

    }
}