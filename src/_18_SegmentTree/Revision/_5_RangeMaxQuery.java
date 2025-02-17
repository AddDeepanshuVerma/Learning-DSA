package _18_SegmentTree.Revision;

public class _5_RangeMaxQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] st = _1_BuildSegmentTree.buildSegmentTree_max(arr);

        // now find the max value in given range
        int left = 1, right = 4;
        int max = rangeMaxQuery(left, right, st, arr);
        System.out.println("min = " + max);
    }

    private static int rangeMaxQuery(int left, int right, int[] st, int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        return RMQ(left, right, i, l, r, st);
    }

    private static int RMQ(int start, int end, int i, int l, int r, int[] st) {
        if (l > end || r < start) {     // out of range hence most invalid answer for finding MAX value.
            return Integer.MIN_VALUE;
        }

        if (l >= start && r <= end) {   // within range hence current node is the answer as we are saving time to go deep down.
            return st[i];
        }

        int mid = (l + r) >> 1;
        int leftMax = RMQ(start, end, 2 * i + 1, l, mid, st);
        int rightMax = RMQ(start, end, 2 * i + 2, mid + 1, r, st);
        return Math.max(rightMax, leftMax);
    }
}
