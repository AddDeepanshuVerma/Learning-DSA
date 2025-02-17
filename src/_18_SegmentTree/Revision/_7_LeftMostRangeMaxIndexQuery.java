package _18_SegmentTree.Revision;

import java.util.ArrayList;
import java.util.List;

public class _7_LeftMostRangeMaxIndexQuery {
    /*
     * Here we need to find out the left most index of an element,
     * which is greater than a given value in the given range of array.
     * */
    /*
     * Step1 : construct the segment tree which stores the index of maximum element int the range of node in tree
     * Step2 : After getting the segment tree array generated, we need to build a function which return the index of max element in any range of array
     * step3 : Now to get the leftMost element we need to follow below steps:
     *       1. We have given an array : arr = {1, 2, 1, 1, 3, 5, 8, 1}
     *       2. Here we need to find the first element which is greater than 2 in the range [2, 7]
     *       3. We construct a SegmentTree than write RMIQ, and then We do a Binary Search
     *       4. Our range of BS would be [2, 7], and we will apply RMIQ in [2, mid]
     *          if we find such index whose element is greater than 2 then to find the leftmost one,
     *          we will shrink our Binary Search space to left side; (r = mid - 1) orElse s = mid + 1
     * step4 : Here binary search shrinking condition is important where we focus on finding the answer in range
     *         rather than finding the answer and shrinking space to ans-1 index.
     * */

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 5, 8, 1};
        // there can be n number of queries, we need to find the leftMost element which is greater the max(arr[a] arr[b])\
        int[][] queries = {{0, 1}, {3, 4}};
        List<Integer> ans = LMRMIQ(arr, queries);
        System.out.println("ans = " + ans);
    }

    private static List<Integer> LMRMIQ(int[] arr, int[][] queries) {
        int[] st = constructSegmentTree(arr);
        List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int minIdx = Math.min(query[0], query[1]);
            int maxIdx = Math.max(query[0], query[1]);
            int maxValue = Math.max(arr[minIdx], arr[maxIdx]);

            int res = Integer.MAX_VALUE;
            // apply binarySearch
            int l = maxIdx + 1, r = arr.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int index = RMIQ(l, mid, st, arr); // a valid answer will always lie bw given range
                if (arr[index] > maxValue) { // we found an answer in the provided range
                    res = Math.min(res, index);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ans.add(res == Integer.MAX_VALUE ? -1 : res);
        }
        return ans;
    }

    private static int RMIQ(int start, int end, int[] st, int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        return queryInRange(start, end, i, l, r, st, arr);
    }

    private static int queryInRange(int start, int end, int i, int l, int r, int[] st, int[] arr) {
        if (l > end || r < start) { // current node of st represent the range which is out of scope
            return -1;
        }

        if (l >= start && r <= end) { // falls within scope
            return st[i];
        }

        int mid = (l + r) >> 1;
        int leftIdx = queryInRange(start, end, 2 * i + 1, l, mid, st, arr);
        int rightIdx = queryInRange(start, end, 2 * i + 2, mid + 1, r, st, arr);

        if (leftIdx == -1 || rightIdx == -1) {
            return leftIdx == -1 ? rightIdx : leftIdx;
        }
        return arr[leftIdx] >= arr[rightIdx] ? leftIdx : rightIdx;
    }

    private static int[] constructSegmentTree(int[] arr) {
        int n = arr.length, i = 0, l = 0, r = n - 1;
        int[] st = new int[n << 2];
        buildTree(i, l, r, arr, st);
        return st;
    }

    private static void buildTree(int i, int l, int r, int[] arr, int[] st) {
        if (l == r) {
            st[i] = l;
            return;
        }

        int mid = (l + r) >> 1;
        buildTree(2 * i + 1, l, mid, arr, st);
        buildTree(2 * i + 2, mid + 1, r, arr, st);

        int leftIdx = st[2 * i + 1];
        int rightIdx = st[2 * i + 2];
        st[i] = arr[leftIdx] >= arr[rightIdx] ? leftIdx : rightIdx;
    }

}





