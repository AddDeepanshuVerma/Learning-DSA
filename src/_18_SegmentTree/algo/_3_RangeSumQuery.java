package _18_SegmentTree.algo;

import java.util.Arrays;

public class _3_RangeSumQuery {
    static int[] nums, segmentTree;

    public static void main(String[] args) {
        nums = new int[]{3, 1, 2, 7};
        segmentTree = new int[nums.length << 2]; // 4*N

        int representIndex = 0;
        buildSegment(representIndex, 0, nums.length - 1);
        System.out.println("segmentTree = " + Arrays.toString(segmentTree));

        int start = 1, end = 3;
        int rangeSum = rangeSum(start, end);
        System.out.println("rangeSum = " + rangeSum);
    }

    private static int rangeSum(int start, int end) {
        int rangeSum = rangeSumQuery(start, end, 0, 0, nums.length - 1);
        return rangeSum;
    }

    private static int rangeSumQuery(int start, int end, int i, int l, int r) {
        if (l > end || r < start) {
            return 0;
        } else if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = (l + r) >> 1;
        int leftSum = rangeSumQuery(start, end, (2 * i) + 1, l, mid);
        int rightSum = rangeSumQuery(start, end, (2 * i) + 2, mid + 1, r);
        return leftSum + rightSum;
    }

    private static void buildSegment(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        buildSegment((2 * i) + 1, l, mid);
        buildSegment((2 * i) + 2, mid + 1, r);
        segmentTree[i] = segmentTree[(2 * i) + 1] + segmentTree[(2 * i) + 2];
    }
}
