package POTD_LEETCODE.SegmentTree;

import java.util.HashMap;

// works within 10^8 === TC : nlogn
class GoodTriplets_2179_2 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        /*
         * Approach :
         * Our segment tree will represent 2nd array on which we will do below operations:
         *   1. we can mark any node as visited as we like
         *   2. we can ask for a range sum based on what will be the last index === [0, lastIndex}
         * Steps :
         *   first store the indexes all the values of our 2nd array
         *   now in the iteration of first array, check how many before this index is common in both array using below :
         *       - common for both on left side  === for the same element in 2nd array how many has been visited
         *       - common for both on right side === total elements on right side - not common on left side
         *   now as soon as each index's value is visited, keep marking them in 2nd array so that in next iteration when
         *   we encounter that, we could count that as visited
         * */
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums2.length;
        for (int i = 0; i < len; i++) {                             // O(n)
            map.put(nums2[i], i);
        }

        long count = 0;
        SegmentTree st = new SegmentTree(len);
        for (int i = 0; i < nums1.length; i++) {                    // O(n)
            int idx = map.get(nums1[i]);
            int leftCommon = idx > 0 ? st.sumTillIdx(idx) : 0;      // O(2 log n)
            int leftUncommon = (i + 1) - 1 - leftCommon;
            int rightCommon = ((len - 1) - idx) - leftUncommon;

            count += (long) leftCommon * rightCommon;
            st.markVisited(idx);                                    // O(log n)
        }
        return count;
    }

    static class SegmentTree {
        int[] st;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            st = new int[n << 2];
            // initially our segment tree represents an array of length n filled with 0's hence st's array length = 4 * n
        }

        void markVisited(int updateIdx) {
            int updateValue = 1;
            update(0, 0, n - 1, updateIdx, updateValue);
        }

        private void update(int i, int l, int r, int updateIdx, int updateValue) {
            if (l == r) {
                st[i] = updateValue;
                return;
            }

            int mid = (l + r) >> 1;
            if (updateIdx <= mid) {
                update(2 * i + 1, l, mid, updateIdx, updateValue);
            } else {
                update(2 * i + 2, mid + 1, r, updateIdx, updateValue);
            }
            st[i] = st[2 * i + 1] + st[2 * i + 2];
        }

        int sumTillIdx(int lastIdx) {
            return rangeSum(0, 0, n - 1, 0, lastIdx - 1);
        }

        private int rangeSum(int i, int l, int r, int start, int end) {
            if (l > end || r < start) { // totally out of scope
                return 0;
            } else if (l >= start && r <= end) { // totally in scope
                return st[i];
            }
            // someWhere in middle hence collapsing
            int mid = (l + r) >> 1;
            int leftSum = rangeSum(2 * i + 1, l, mid, start, end);
            int rightSum = rangeSum(2 * i + 2, mid + 1, r, start, end);
            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {2, 0, 1, 3};
        int[] n2 = {0, 1, 2, 3};
        var obj = new GoodTriplets_2179_2();
        long count = obj.goodTriplets(n1, n2);
        System.out.println("count = " + count);
    }
}