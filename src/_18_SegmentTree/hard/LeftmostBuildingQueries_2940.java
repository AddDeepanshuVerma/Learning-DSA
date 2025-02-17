package _18_SegmentTree.hard;

import java.util.Arrays;

class LeftmostBuildingQueries_2940 {
    public static void main(String[] args) {
        int[] heights = {1, 2, 1, 2, 1, 2};
//        int[][] queries = {{0, 0}, {0, 1}, {0, 2}};
        int[][] queries = {{0, 2}};
        LeftmostBuildingQueries_2940 obj = new LeftmostBuildingQueries_2940();
        int[] ans = obj.leftmostBuildingQueries(heights, queries);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] st = constructSegmentTree(heights);

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int minIdx = Math.min(queries[i][0], queries[i][1]);
            int maxIdx = Math.max(queries[i][0], queries[i][1]);
            int maxValue = Math.max(heights[minIdx], heights[maxIdx]);
            if (minIdx == maxIdx) {
                ans[i] = minIdx;
                continue;
            } else if (heights[maxIdx] > heights[minIdx]) {
                ans[i] = maxIdx;
                continue;
            }

            // now need to apply BinarySearch on RMIQ
            int l = maxIdx + 1, r = heights.length - 1;
            int res = Integer.MAX_VALUE;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int index = RMIQ(l, mid, st, heights);
                if (heights[index] > maxValue) {
                    res = index;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = res == Integer.MAX_VALUE ? -1 : res;
        }
        return ans;
    }

    private static int RMIQ(int start, int end, int[] st, int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        return queryInRange(start, end, i, l, r, st, arr);
    }

    private static int queryInRange(int start, int end, int i, int l, int r, int[] st, int[] arr) {
        if (l > end || r < start) { // current node of st represent the range which is out of scope
            return -1;
        }

        if (l >= start && r <= end) { // falls within scope
            return st[i];
        }

        int mid = (l + r) >> 1;
        int leftIdx = queryInRange(start, end, 2 * i + 1, l, mid, st, arr);
        int rightIdx = queryInRange(start, end, 2 * i + 2, mid + 1, r, st, arr);

        if (leftIdx == -1 || rightIdx == -1) {
            return leftIdx == -1 ? rightIdx : leftIdx;
        }
        return arr[leftIdx] >= arr[rightIdx] ? leftIdx : rightIdx;
    }

    private static int[] constructSegmentTree(int[] arr) {
        int n = arr.length, i = 0, l = 0, r = n - 1;
        int[] st = new int[n << 2];
        buildTree(i, l, r, arr, st);
        return st;
    }

    private static void buildTree(int i, int l, int r, int[] arr, int[] st) {
        if (l == r) {
            st[i] = l;
            return;
        }

        int mid = (l + r) >> 1;
        buildTree(2 * i + 1, l, mid, arr, st);
        buildTree(2 * i + 2, mid + 1, r, arr, st);

        int leftIdx = st[2 * i + 1];
        int rightIdx = st[2 * i + 2];
        st[i] = arr[leftIdx] >= arr[rightIdx] ? leftIdx : rightIdx;
    }
}