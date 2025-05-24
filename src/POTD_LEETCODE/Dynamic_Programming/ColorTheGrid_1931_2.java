package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

class ColorTheGrid_1931_2 {
    final int MOD = (int) (1e9 + 7);
    private final List<String> all = new ArrayList<>();
    private Integer[][] dp;

    public int colorTheGrid(int m, int n) {
        all.clear();
        permutation('#', "", m);

        dp = new Integer[all.size()][n];
        int ways = 0;
        for (int i = 0; i < all.size(); i++) {
            ways = (ways + dfs(i, n - 1, m)) % MOD;
        }
        return ways;
    }

    private int dfs(int prev, int remaining, int m) {
        if (remaining == 0) return 1;

        if (dp[prev][remaining] != null) return dp[prev][remaining];

        int ways = 0;
        for (int curr = 0; curr < all.size(); curr++) {
            if (curr == prev || isSame(prev, curr, m)) continue;
            ways = (ways + dfs(curr, remaining - 1, m)) % MOD;
        }

        return dp[prev][remaining] = ways;
    }

    private boolean isSame(int i, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (all.get(i).charAt(k) == all.get(j).charAt(k)) return true;
        }
        return false;
    }

    private void permutation(char prev, String curr, int m) {
        if (curr.length() == m) {
            all.add(curr);
        } else {
            for (char ch : new char[]{'R', 'G', 'B'}) {
                if (ch == prev) continue;
                permutation(ch, curr + ch, m);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new ColorTheGrid_1931_2();
        int ways = obj.colorTheGrid(5, 5);
        System.out.println("ways = " + ways);
    }
}