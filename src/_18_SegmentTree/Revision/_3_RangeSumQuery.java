package _18_SegmentTree.Revision;

import java.util.Arrays;

public class _3_RangeSumQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] st = _1_BuildSegmentTree.buildSegmentTree_sum(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("st = " + Arrays.toString(st));
        // now get the sum of some range within this array
        int start = 1, end = 3;
        int sum = getSumRange(start, end, st, arr);
        System.out.println(sum);
    }

    private static int getSumRange(int start, int end, int[] st, int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        return getSum(i, l, r, start, end, st);
    }

    private static int getSum(int i, int l, int r, int start, int end, int[] st) {
        if (l > end || r < start) { // out current node of segment tree is out of range
            return 0;
        } else if (l >= start && r <= end) { // out current node of segment tree is completely inside the range
            return st[i];
        }

        // current node range is neither completely inside nor outside hence need to break down that node further
        int mid = (l + r) >> 1;
        int leftSum = getSum(2 * i + 1, l, mid, start, end, st);
        int rightSum = getSum(2 * i + 2, mid + 1, r, start, end, st);
        return leftSum + rightSum;
    }
}
