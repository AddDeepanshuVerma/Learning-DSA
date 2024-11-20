package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.List;

class FindKthNumber_440 {
    public int findKthNumber(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(i, n, list);
        }

        return list.get(k - 1);
    }

    private void solve(int val, int n, List<Integer> list) {
        if (val > n) return;
        list.add(val);
        for (int i = 0; i <= 9; i++) {
            solve(val * 10 + i, n, list);
        }
    }
}