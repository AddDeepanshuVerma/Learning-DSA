package _18_SegmentTree.hard;

import java.util.*;

class SegmentTree {
    private final int n;
    private final int[] st;

    public SegmentTree(List<Integer> nums) {
        this.n = nums.size();
        this.st = new int[n * 4];
        construct(nums, 0, 0, n - 1);
    }

    // Adds val to nums[idx].
    public void increment(int idx, int val) {
        increment(0, 0, n - 1, idx, val);
    }

    // Returns sum(nums[start..end]).
    public int rangeSum(int start, int end) {
        return query(0, 0, n - 1, start, end);
    }

    private void construct(List<Integer> nums, int i, int l, int r) {
        if (l == r) {
            st[i] = nums.get(l);
            return;
        }
        int mid = (l + r) / 2;
        construct(nums, 2 * i + 1, l, mid);
        construct(nums, 2 * i + 2, mid + 1, r);
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }

    private void increment(int i, int l, int r, int idx, int val) {
        if (l == r) {
            st[i] += val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) increment(2 * i + 1, l, mid, idx, val);
        else increment(2 * i + 2, mid + 1, r, idx, val);
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }

    private int query(int i, int l, int r, int start, int end) {
        if (l >= start && r <= end) {  // [l, r] lies completely inside [start, end].
            return st[i];
        }
        if (l > end || r < start) {  // [l, r] lies completely outside [start, end].
            return 0;
        }
        int mid = (l + r) / 2;
        return query(2 * i + 1, l, mid, start, end) + query(2 * i + 2, mid + 1, r, start, end);
    }
}

class Solution {
    public List<Integer> countSmaller(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>(Collections.nCopies(nums.size(), 0));
        Map<Integer, Integer> ranks = new HashMap<>();
        getRanks(nums, ranks);
        SegmentTree tree = new SegmentTree(new ArrayList<>(Collections.nCopies(ranks.size() + 1, 0)));

        for (int i = nums.size() - 1; i >= 0; --i) {
            int num = nums.get(i);
            ans.set(i, tree.rangeSum(0, ranks.get(num) - 1));
            tree.increment(ranks.get(num), 1);
        }

        return ans;
    }

    private void getRanks(List<Integer> nums, Map<Integer, Integer> ranks) {
        Set<Integer> sorted = new TreeSet<>(nums);
        int rank = 0;
        for (int num : sorted) {
            ranks.put(num, ++rank);
        }
    }
}
