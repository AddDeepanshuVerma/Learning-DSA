package _18_SegmentTree.algo;

import java.util.Arrays;

public class UpdateSegmentTree {
    static int[] nums, segmentTree;

    public static void main(String[] args) {
        nums = new int[]{3, 1, 2, 7};
        segmentTree = new int[nums.length << 2];

        int rootIndex = 0, left = 0, right = nums.length - 1;
        buildSegmentTree(rootIndex, left, right);
        System.out.println("        Segment Tree = " + Arrays.toString(segmentTree));

        int index = 1;
        int updateValue = 5;
        updateSegmentTree(index, updateValue);

        System.out.println("Updated Segment Tree = " + Arrays.toString(segmentTree));
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

    private static void updateSegmentTree(int idx, int val) {
        int i = 0, l = 0, r = nums.length - 1;
        updateSegmentTree(idx, val, i, l, r);
    }

    private static void updateSegmentTree(int idx, int val, int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = val; //if (l == idx) segmentTree[i] = val;
            return;
        }

        int mid = (l + r) >> 1;
        if (idx <= mid) { // left child
            updateSegmentTree(idx, val, (2 * i) + 1, l, mid);
        } else { // left child
            updateSegmentTree(idx, val, (2 * i) + 2, mid + 1, r);
        }

        segmentTree[i] = segmentTree[(2 * i) + 1] + segmentTree[(2 * i) + 2];
    }
}