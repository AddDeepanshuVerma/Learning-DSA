package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

class _22_CoinChange_2_2D {
    public static void main(String[] args) {
        System.out.println(count(new int[]{2, 4}, 5));
    }

    public static int count(int[] coins, int sum) {
        int[][] t = new int[coins.length + 1][sum + 1];

        for (int col = 1; col < sum + 1; col++) {
            t[0][col] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int exclude = t[i - 1][j];

                int include = Integer.MAX_VALUE - 1;
                if (coins[i - 1] <= j) {
                    include = t[i][j - coins[i - 1]];
                }
                t[i][j] = Math.min(exclude, 1 + include);
            }
        }
        for (int[] ints : t) {
            System.out.println(Arrays.toString(ints));
        }

        return t[coins.length][sum] == Integer.MAX_VALUE - 1 ? -1 : t[coins.length][sum];
    }
}