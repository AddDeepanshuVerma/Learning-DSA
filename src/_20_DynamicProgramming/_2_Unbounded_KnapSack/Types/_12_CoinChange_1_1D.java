package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

class _12_CoinChange_1_1D {
    public int count(int[] coins, int sum) {
        int[] t = new int[sum + 1];

        t[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < sum + 1; j++) {
                t[j] += t[j - coins[i]];
            }
        }
        return t[sum];
    }
}