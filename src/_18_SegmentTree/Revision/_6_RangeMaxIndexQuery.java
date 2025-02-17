package _18_SegmentTree.Revision;

import java.util.Arrays;

public class _6_RangeMaxIndexQuery {
    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 4, 5, 6, 7, 8};
        int[] st = buildSegmentTree(arr);
        System.out.println("st = " + Arrays.toString(st));

        // now find max value's index in a given range
        int left = 1, right = 5;
        int index = maxValueIndex(left, right, arr, st);
        System.out.println("index = " + index);
    }

    private static int maxValueIndex(int left, int right, int[] arr, int[] st) {
        int i = 0, l = 0, r = arr.length - 1;
        return RMIQ(left, right, i, l, r, arr, st);
    }

    private static int RMIQ(int start, int end, int i, int l, int r, int[] arr, int[] st) {
        if (l > end || r < start) {
            return -1;
        }
        if (l >= start && r <= end) {
            return st[i];
        }

        int mid = (l + r) >> 1;
        int leftIdx = RMIQ(start, end, 2 * i + 1, l, mid, arr, st);
        int rightIdx = RMIQ(start, end, 2 * i + 2, mid + 1, r, arr, st);
        //        if (leftIdx == -1 && rightIdx == -1) {
        //            return -1;
        //        } else if (leftIdx == -1 || rightIdx == -1) {
        //            return leftIdx == -1 ? rightIdx : leftIdx;
        //        }
        // both will never be -1 as if one side was found outOfRange, we are not digging it further
        if (leftIdx == -1 || rightIdx == -1) {
            return leftIdx == -1 ? rightIdx : leftIdx;
        }
        return arr[leftIdx] > arr[rightIdx] ? leftIdx : rightIdx;
    }

    private static int[] buildSegmentTree(int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        int[] st = new int[arr.length << 2];
        buildTree(i, l, r, st, arr);
        return st;
    }

    private static void buildTree(int i, int l, int r, int[] st, int[] arr) {
        if (l == r) {
            st[i] = l;
            return;
        }

        int mid = (l + r) >> 1;
        buildTree(2 * i + 1, l, mid, st, arr);
        buildTree(2 * i + 2, mid + 1, r, st, arr);

        int leftIdx = st[2 * i + 1];
        int rightIdx = st[2 * i + 2];
        st[i] = arr[leftIdx] > arr[rightIdx] ? leftIdx : rightIdx;
    }
}
