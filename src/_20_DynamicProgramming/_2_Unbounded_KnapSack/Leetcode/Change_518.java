package _20_DynamicProgramming._2_Unbounded_KnapSack.Leetcode;

class Change_518 {
    public int change(int amount, int[] coins) {
        int[] t = new int[amount + 1];
        t[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j < t.length; j++) {
                t[j] += t[j - coin];
            }
        }
        return t[amount];
    }
}