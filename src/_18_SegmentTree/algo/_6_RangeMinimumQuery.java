package _18_SegmentTree.algo;

public class _6_RangeMinimumQuery {
    static int[] st;

    public static int[] constructST(int arr[], int n) {
        st = new int[n * 4];
        buildMinSegmentTree(0, 0, n - 1, arr);
        return st;
    }

    private static void buildMinSegmentTree(int i, int l, int r, int[] nums) {
        if (l == r) {
            st[i] = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        buildMinSegmentTree(2 * i + 1, l, mid, nums);
        buildMinSegmentTree(2 * i + 2, mid + 1, r, nums);
        st[i] = Math.min(st[2 * i + 1], st[2 * i + 2]);
    }


    /* The function returns the min element in the range from l and r */
    public static int RMQ(int[] st, int n, int l, int r) {
        return getMinInRange(l, r, 0, 0, n - 1, st);
    }

    private static int getMinInRange(int start, int end, int i, int l, int r, int[] st) {
        if (l > end || r < start) {
            return Integer.MAX_VALUE; // this is invalid node hence most invalid response needs to be returned.
        } else if (l >= start && r <= end) {
            return st[i];
        }

        int mid = (l + r) >> 1;
        int leftMin = getMinInRange(start, end, 2 * i + 1, l, mid, st);
        int rightMIn = getMinInRange(start, end, 2 * i + 2, mid + 1, r, st);

        return Math.min(rightMIn, leftMin);
    }
}
