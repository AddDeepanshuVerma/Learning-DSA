package _18_SegmentTree.algo;

import java.util.Arrays;

public class _1_BuildSegmentTree {
    static int[] nums, segmentTree;

    public static void main(String[] args) {
        nums = new int[]{3, 1, 2, 7};
        segmentTree = new int[nums.length << 2];

        int rootIndex = 0, left = 0, right = nums.length - 1;
        buildSegmentTree(rootIndex, left, right);

        System.out.println("se = " + Arrays.toString(segmentTree));
    }

    // i represent      : index of segment array
    // [l, r] represent : range for that index
    private static void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l]; // = nums[r];
            return;
        }

        int mid = (l + r) >> 1;
        buildSegmentTree(2 * i + 1, l, mid);
        buildSegmentTree(2 * i + 2, mid + 1, r);

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2]; // here + makes the segment tree : a range sum segment tree
    }
}
