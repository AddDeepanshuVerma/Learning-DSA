package _18_SegmentTree.algo;

import java.util.Arrays;

public class _7_UpdateRangeInSegmentTree {
    static int[] segmentTree, nums, lazy;

    public static void main(String[] args) {
//        nums = new int[]{3, 1, 2, 7};
        nums = new int[]{1, 2, 3, 4, 5, 6};
        segmentTree = new int[nums.length * 4];
        buildSegmentTree(0, 0, nums.length - 1);
        System.out.println("segmentTree = " + Arrays.toString(segmentTree));

        int from = 1, till = 3;
        int increase = 2;
        lazy = new int[segmentTree.length];
        updateRangeInSegmentTree(from, till, increase);
        System.out.println("segmentTree = " + Arrays.toString(segmentTree));
    }

    private static void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = (l + r) >> 1;
        buildSegmentTree(2 * i + 1, l, mid);
        buildSegmentTree(2 * i + 2, mid + 1, r);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    private static void updateRangeInSegmentTree(int from, int till, int increase) {
        // adding required parameters
        updateRange(from, till, 0, 0, nums.length - 1, increase);
    }

    private static void updateRange(int start, int end, int i, int l, int r, int val) {
        if (lazy[i] != 0) {
            segmentTree[i] += (r - l + 1) * lazy[i];
            if (l != r) {
                lazy[2 * i + 1] += lazy[i]; // forgot we need to add += not update =
                lazy[2 * i + 2] += lazy[i]; // forgot we need to add += not update =
            }
            lazy[i] = 0;
        }

        if (l > end || r < start || l > r) { // out of bound case && here l > r is for over smart users
            return;
        }
        if (l >= start && r <= end) { // inBound case
            segmentTree[i] += (r - l + 1) * val;
            if (l != r) {
                lazy[2 * i + 1] += val;
                lazy[2 * i + 2] += val;
            }
            return;
        }
        // overlapping case
        int mid = (l + r) >> 1;
        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
}
