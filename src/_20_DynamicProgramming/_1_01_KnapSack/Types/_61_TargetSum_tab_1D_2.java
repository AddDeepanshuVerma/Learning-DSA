package _20_DynamicProgramming._1_01_KnapSack.Types;

class _61_TargetSum_tab_1D_2 {
    public static void main(String[] args) {
        int[] arr = {1000};
        System.out.println(findTargetSumWays(arr, -1000));

    }

    public static int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (((target + sum) & 1) == 1) return 0; // if it's not even both Subset combined not equal to whole array
        return countOfSubsetSum(arr, (target + sum) >> 1);
    }

    private static int countOfSubsetSum(int[] arr, int target) {
        int[] t = new int[target + 1];
        t[0] = 1;
        for (int i = 0; i < arr.length; i++)
            for (int sum = target; sum >= arr[i]; sum--)
                t[sum] += t[sum - arr[i]];
        return t[target];
    }
}