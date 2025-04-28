package _18_SegmentTree.Revision;

import java.util.Arrays;

public class _4_UpdateRangeQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] st = _1_BuildSegmentTree.buildSegmentTree_sum(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("st = " + Arrays.toString(st));

        int start = 1, end = 3, update = 2;
        int[] lazy = new int[st.length];
        updateRange(start, end, update, arr, st, lazy);
        System.out.println("after update range \nst = " + Arrays.toString(st));
        System.out.println("lazy = " + Arrays.toString(lazy));

        updateWholeTree(0, 0, arr.length - 1, st, lazy);
        System.out.println("after update lazy\nst = " + Arrays.toString(st));
        System.out.println("lazy = " + Arrays.toString(lazy));
    }

    private static void updateRange(int start, int end, int update, int[] arr, int[] st, int[] lazy) {
        int i = 0, l = 0, r = arr.length - 1;
        updateST(i, l, r, start, end, update, arr, st, lazy);
    }

    private static void updateST(int i, int l, int r, int start, int end, int update, int[] arr, int[] st, int[] lazy) {
        // update lazy loaded array
        if (lazy[i] != 0) {
            st[i] += (r - l + 1) * lazy[i];
            if (l != r) {
                st[2 * i + 1] += lazy[i];
                st[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }

        if (l > end || r < start) return; // out of range

        if (l >= start && r <= end) { // within range
            st[i] += (r - l + 1) * update;
            if (l != r) {
                lazy[2 * i + 1] += update;
                lazy[2 * i + 2] += update;
            }
            return;
        }

        // now node range is overlapping
        int mid = (l + r) >> 1;
        updateST(2 * i + 1, l, mid, start, end, update, arr, st, lazy);
        updateST(2 * i + 2, mid + 1, r, start, end, update, arr, st, lazy);
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }

    private static void updateWholeTree(int i, int l, int r, int[] st, int[] lazy) {
        if (lazy[i] != 0) {
            st[i] += (r - l + 1) * lazy[i];
            if (l != r) {
                st[2 * i + 1] += lazy[i];
                st[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }

        if (l == r) return;
        int mid = (l + r) >> 1;
        updateWholeTree(2 * i + 1, l, mid, st, lazy);
        updateWholeTree(2 * i + 2, mid + 1, r, st, lazy);
    }
}
