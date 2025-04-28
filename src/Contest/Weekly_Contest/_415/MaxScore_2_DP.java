package Contest.Weekly_Contest._415;

import java.util.Arrays;

// Does work
class MaxScore_2_DP {
    public static void main(String[] args) {
        int[] a = {-1, 4, 5, -2};
        int[] b = {-5, -1, -3, -2, -4};
        MaxScore_2_DP obj = new MaxScore_2_DP();
        System.out.println(obj.maxScore(a, b));

        int[] a1 = {3, 2, 5, 6};
        int[] b1 = {2, -6, 4, -5, -3, 2, -7};
//        System.out.println(obj.maxScore(a1, b1));
    }

    private long helper(int[] a, int[] b, int index, int count, long[][] memo) {
        if (index == a.length) return 0;
        if (count >= b.length) return (long) -1e9;

        if (memo[index][count] != -1) return memo[index][count];

        long take = (long) a[index] * b[count] + helper(a, b, index + 1, count + 1, memo);
        long notTake = helper(a, b, index, count + 1, memo);

        memo[index][count] = Math.max(take, notTake);
        return memo[index][count];
    }

    public long maxScore(int[] a, int[] b) {
        long[][] memo = new long[4][b.length];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(a, b, 0, 0, memo);
    }
}