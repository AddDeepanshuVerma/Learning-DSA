package _18_SegmentTree.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5_QuerySum2 {
    public static void main(String[] args) {
        int[] arr = {26, 30, 48, 29, 8};
        int[] queries = {4, 4, 2, 3};
        List<Integer> ans = querySum(arr.length, arr, queries.length >> 1, queries);
        System.out.println("ans = " + ans);
    }

    static int[] nums, segmentTree;

    static List<Integer> querySum(int n, int[] arr, int q, int[] queries) {
        nums = arr;
        segmentTree = new int[nums.length * 4];

        constructSegmentTree(0, 0, nums.length - 1);
        System.out.println("segmentTree = " + Arrays.toString(segmentTree));

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i += 2) {
            ans.add(rangeSumQuery(queries[i] - 1, queries[i + 1] - 1));
        }
        return ans;
        // code here
    }

    private static Integer rangeSumQuery(int start, int end) {
        return rangeSum(start, end, 0, 0, nums.length - 1);
    }

    private static Integer rangeSum(int start, int end, int i, int l, int r) {
        if (l > end || r < start) {
            return 0;
        } else if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = (l + r) >> 1;
        int leftSum = rangeSum(start, end, 2 * i + 1, l, mid);
        int rightSum = rangeSum(start, end, 2 * i + 2, mid + 1, r);

        return leftSum + rightSum;
    }

    private static void constructSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        constructSegmentTree(2 * i + 1, l, mid);
        constructSegmentTree(2 * i + 2, mid + 1, r);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
}
