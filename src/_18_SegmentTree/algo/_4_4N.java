package _18_SegmentTree.algo;

import java.util.Arrays;

public class _4_4N {
    static int[] nums, segmentTree;

    public static void main(String[] args) {
        nums = new int[]{1, 2, 3, 4, 5, 6};
//        segmentTree = new int[nums.length * 2]; // TLE when i == 12 && l == r == 4
        segmentTree = new int[nums.length * 4];

        buildSegmentTree(0, 0, nums.length - 1);
        System.out.println("segmentTree = " + Arrays.toString(segmentTree));
    }

    private static void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = (l + r) >> 1;
        buildSegmentTree((2 * i) + 1, l, mid);
        buildSegmentTree((2 * i) + 2, mid + 1, r);
        segmentTree[i] = segmentTree[(2 * i) + 1] + segmentTree[(2 * i) + 2];
    }
}
