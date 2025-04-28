package _18_SegmentTree.medium;

class MinimumSubarrayLength_3097_2 {
    public static void main(String[] args) {
        MinimumSubarrayLength_3097_2 obj = new MinimumSubarrayLength_3097_2();
        int[] nums = {2, 1, 8};
        int k = 10;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] st = new int[n << 2];
        buildSegmentTree(0, 0, n - 1, st, nums);

        int i = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            while (i <= j && getOr(i, j, nums, st) >= k) {
                ans = Math.min(ans, j - i + 1);
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int getOr(int start, int end, int[] nums, int[] st) {
        return getInterval(start, end, 0, 0, nums.length - 1, st);
    }

    private int getInterval(int start, int end, int i, int l, int r, int[] st) {
        if (l > end || r < start) return 0;
        if (l >= start && r <= end) return st[i];

        int mid = (l + r) >> 1;
        int left = getInterval(start, end, 2 * i + 1, l, mid, st);
        int right = getInterval(start, end, 2 * i + 2, mid + 1, r, st);
        return left | right;
    }

    private void buildSegmentTree(int i, int l, int r, int[] st, int[] nums) {
        if (l == r) {
            st[i] = nums[l];
            return;
        }

        int mid = (l + r) >> 1;
        buildSegmentTree(2 * i + 1, l, mid, st, nums);
        buildSegmentTree(2 * i + 2, mid + 1, r, st, nums);
        st[i] = st[2 * i + 1] | st[2 * i + 2];
    }
}