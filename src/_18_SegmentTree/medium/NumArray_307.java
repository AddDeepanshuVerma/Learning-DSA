package _18_SegmentTree.medium;

class NumArray_307 {

    int[] segmentTree, nums;

    public NumArray_307(int[] nums) {
        segmentTree = new int[nums.length * 4];
        this.nums = nums;
        buildSegmentTree(0, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateSegTree(0, 0, nums.length - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return rangeSum(left, right, 0, 0, nums.length - 1);
    }

    private void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        buildSegmentTree(2 * i + 1, l, mid);
        buildSegmentTree(2 * i + 2, mid + 1, r);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    private void updateSegTree(int i, int l, int r, int idx, int val) {
        if (l == r) {
            segmentTree[i] = val;
            return;
        }

        int mid = (l + r) >> 1;
        if (idx <= mid) {
            updateSegTree(2 * i + 1, l, mid, idx, val);
        } else {
            updateSegTree(2 * i + 2, mid + 1, r, idx, val);
        }
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    private int rangeSum(int start, int end, int i, int l, int r) {
        if (l > end || r < start || l > r) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = (l + r) >> 1;
        int leftSum = rangeSum(start, end, 2 * i + 1, l, mid);
        int rightSum = rangeSum(start, end, 2 * i + 2, mid + 1, r);
        return leftSum + rightSum;
    }
}