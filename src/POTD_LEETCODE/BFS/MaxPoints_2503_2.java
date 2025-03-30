package POTD_LEETCODE.BFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class MaxPoints_2503_2 {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;

        int[] clone = queries.clone();
        Arrays.sort(clone);

        int len = queries.length;
        int[] prefix = new int[len + 1];
        prefix[len] = (int) 1e7;// to make Binary Search easier to read

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] coordinate = pq.poll();
            int row = coordinate[0], col = coordinate[1];
            int max = coordinate[2];

            // now increment count of all values in clone array > u
            prefix[search(max, clone, prefix)]++;

            for (int[] dir : dirs) {
                int nRow = dir[0] + row, nCol = dir[1] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || visited[nRow][nCol]) continue;

                visited[nRow][nCol] = true;
                pq.offer(new int[]{nRow, nCol, Math.max(max, grid[nRow][nCol])});
            }
        }

        // now store all the values from prefix & clone array in HashMap to provide answer in given order
        HashMap<Integer, Integer> map = new HashMap<>();
        int prev = 0;
        for (int i = 0; i < clone.length; i++) {
            prev += prefix[i];
            map.put(clone[i], prev);
        }

        // now compute the answer in required order using HashMap & given data
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(queries[i]);
        }
        return ans;
    }

    // here we will increment 1 count of all values which are strictly greater than target
    // Hence do a binary search in sorted clone array and find the first index > target
    private int search(int target, int[] clone, int[] prefix) {
        int start = 0, end = clone.length - 1;
        int index = clone.length; // if nothing found then 1e7 is always there
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (clone[mid] > target) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MaxPoints_2503_2 obj = new MaxPoints_2503_2();
        int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
        int[] queries = {5, 6, 2};
        int[] ans = obj.maxPoints(grid, queries);
        System.out.println(Arrays.toString(ans));
    }
}