package _18_SegmentTree.medium;

import jdk.jfr.Description;

@Description("Segment tree approach of lazy propagation")
class ShiftingLetters_2381 {
    public static void main(String[] args) {
        String s = "abz";
        int[][] shifts = {{0, 1, 0}, {1, 2, 0}, {0, 2, 0}};
        System.out.println(shiftingLetters(s, shifts));
    }

    static class SegmentTree {
        private int[] tree, lazy;
        private int n;

        public SegmentTree(int size) {
            n = size;
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        private void applyLazy(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2 + 1] += lazy[node];
                    lazy[node * 2 + 2] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        public void updateRange(int l, int r, int value) {
            updateRange(0, 0, n - 1, l, r, value);
        }

        private void updateRange(int node, int start, int end, int l, int r, int value) {
            applyLazy(node, start, end);
            if (start > end || start > r || end < l) {
                return;
            }
            if (start >= l && end <= r) {
                tree[node] += (end - start + 1) * value;
                if (start != end) {
                    lazy[node * 2 + 1] += value;
                    lazy[node * 2 + 2] += value;
                }
                return;
            }
            int mid = (start + end) / 2;
            updateRange(node * 2 + 1, start, mid, l, r, value);
            updateRange(node * 2 + 2, mid + 1, end, l, r, value);
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }

        public int query(int idx) {
            return query(0, 0, n - 1, idx);
        }

        private int query(int node, int start, int end, int idx) {
            applyLazy(node, start, end);
            if (start > end || idx < start || idx > end) {
                return 0;
            }
            if (start == end) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                return query(node * 2 + 1, start, mid, idx);
            } else {
                return query(node * 2 + 2, mid + 1, end, idx);
            }
        }
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        SegmentTree segTree = new SegmentTree(n);

        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            int value = (direction == 1) ? 1 : -1;
            segTree.updateRange(start, end, value);
        }

        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            int shift = segTree.query(i);
            int originalPos = s.charAt(i) - 'a';
            int newPos = (originalPos + shift) % 26;
            if (newPos < 0) newPos += 26;
            res.setCharAt(i, (char) ('a' + newPos));
        }

        return res.toString();
    }
}