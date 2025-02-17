package _18_SegmentTree.Revision;

import java.util.Arrays;

public class _2_UpdateSegmentTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] st = _1_BuildSegmentTree.buildSegmentTree_sum(arr);
        System.out.println(Arrays.toString(st));

        // now we need to update
        int newVal = 10, updateIdx = 4;
        updateSegmentTree(updateIdx, newVal, st, arr);
        System.out.println(Arrays.toString(st));
    }

    private static void updateSegmentTree(int updateIdx, int newVal, int[] st, int[] arr) {
        int segmentIdx = 0, start = 0, end = arr.length - 1;
        updateTree(segmentIdx, start, end, st, arr, updateIdx, newVal);
    }

    private static void updateTree(int segmentIdx, int start, int end, int[] st, int[] arr, int updateIdx, int newVal) {
        if (start == end) {
            st[segmentIdx] = newVal;
            return;
        }

        int mid = (start + end) >> 1;
        if (updateIdx <= mid) {
            updateTree(2 * segmentIdx + 1, start, mid, st, arr, updateIdx, newVal);
        } else {
            updateTree(2 * segmentIdx + 2, mid + 1, end, st, arr, updateIdx, newVal);
        }
        st[segmentIdx] = st[2 * segmentIdx + 1] + st[2 * segmentIdx + 2];
    }
}
