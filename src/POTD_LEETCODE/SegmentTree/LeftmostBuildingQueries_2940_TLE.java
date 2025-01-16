package POTD_LEETCODE.SegmentTree;

class LeftmostBuildingQueries_2940_TLE {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = findIndex(heights, queries[i][0], queries[i][1]);
        }
        return ans;
    }

    private int findIndex(int[] arr, int i, int j) {
        if (i == j) return i;
        if (i < j && arr[i] < arr[j]) return j;
        if (j < i && arr[j] < arr[i]) return i;

        // now we need to find an index greater then max(i, j)th & with value greater then max(arr[i], arr[j])
        int maxVal = Math.max(arr[i], arr[j]);
        int maxIndex = Math.max(i, j);

        for (int k = maxIndex + 1; k < arr.length; k++) {
            if (arr[k] > maxVal) {
                return k;
            }
        }
        return -1;
    }
}