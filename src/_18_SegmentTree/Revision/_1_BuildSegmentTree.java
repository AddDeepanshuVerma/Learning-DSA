package _18_SegmentTree.Revision;

import java.util.Arrays;

public class _1_BuildSegmentTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] st = buildSegmentTree_max(arr);
        System.out.println("Segment Tree Array = " + Arrays.toString(st));
    }

    public static int[] buildSegmentTree_sum(int[] arr) {
        int n = arr.length;
        int[] st = new int[n << 2]; // segment tree array has to be of 4N length

        int start = 0, end = n - 1, index = 0;
        buildSegmentTreeS(index, start, end, st, arr);

        return st;
    }

    private static void buildSegmentTreeS(int segmentIdx, int start, int end, int[] st, int[] arr) {
        if (start == end) {
            st[segmentIdx] = arr[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildSegmentTreeS(2 * segmentIdx + 1, start, mid, st, arr);
        buildSegmentTreeS(2 * segmentIdx + 2, mid + 1, end, st, arr);
        st[segmentIdx] = st[2 * segmentIdx + 1] + st[2 * segmentIdx + 2];
    }

    public static int[] buildSegmentTree_max(int[] arr) {
        int n = arr.length;
        int[] st = new int[n << 2];
        int l = 0, r = n - 1, i = 0;
        buildSegmentTreeM(i, l, r, arr, st);
        return st;
    }

    private static void buildSegmentTreeM(int i, int l, int r, int[] arr, int[] st) {
        if (l == r) {
            st[i] = arr[l];
            return;
        }

        int mid = (l + r) >> 1;
        buildSegmentTreeM(2 * i + 1, l, mid, arr, st);
        buildSegmentTreeM(2 * i + 2, mid + 1, r, arr, st);
        st[i] = Math.max(st[2 * i + 1], st[2 * i + 2]);
    }
}
