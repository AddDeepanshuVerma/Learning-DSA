package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

class _23_CoinChange_2_1D {
    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3}, 5));
    }

    public static int count(int[] coins, int sum) {
        int[] t = new int[sum + 1];

        Arrays.fill(t, Integer.MAX_VALUE - 1);
        t[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < sum + 1; j++) {
                t[j] = Math.min(t[j], 1 + t[j - coins[i]]);
            }
        }

        System.out.println(Arrays.toString(t));
        return t[sum] == Integer.MAX_VALUE - 1 ? -1 : t[sum];
    }

    public static int count2(int[] coins, int sum) {
        int[] t = new int[sum + 1];

        for (int col = 1; col < sum + 1; col++) {
            t[col] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < sum + 1; j++) {
                t[j] = Math.min(t[j], 1 + t[j - coins[i]]);
            }
        }

        System.out.println(Arrays.toString(t));
        return t[sum] == Integer.MAX_VALUE - 1 ? -1 : t[sum];
    }
}