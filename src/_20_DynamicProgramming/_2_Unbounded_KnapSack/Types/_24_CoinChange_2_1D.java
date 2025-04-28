package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

class _24_CoinChange_2_1D {
    public static void main(String[] args) {
        int miniElements = count(new int[]{2, 4}, 5);
        System.out.println(miniElements);
    }

    public static int count(int[] coins, int sum) {
        int[] t = new int[sum + 1];

        for (int col = 0; col < sum + 1; col++) {
            if (col % coins[0] == 0) t[col] = col / coins[0];
            else t[col] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = coins[i]; j < sum + 1; j++) {
                t[j] = Math.min(t[j], 1 + t[j - coins[i]]);
            }
        }

        System.out.println(Arrays.toString(t));
        return t[sum] == Integer.MAX_VALUE - 1 ? -1 : t[sum];
    }
}