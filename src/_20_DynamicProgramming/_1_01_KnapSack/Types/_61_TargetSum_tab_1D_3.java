package _20_DynamicProgramming._1_01_KnapSack.Types;

class _61_TargetSum_tab_1D_3 {
    public static void main(String[] args) {
        int[] arr = {1000};
        System.out.println(findTargetSumWays(arr, -1000));

    }

    public static int findTargetSumWays(int[] nums, int diff) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < diff || (diff + sum) % 2 > 0 ? 0 : subsetSum(nums, (diff + sum) >>> 1);
    }

    public static int subsetSum(int[] nums, int s) {
        int[] t = new int[s + 1];
        t[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                t[i] += t[i - n];
        return t[s];
    }
}