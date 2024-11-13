package _20_DynamicProgramming._1_01_KnapSack.Types;

class _61_TargetSum_tab_1D_2 {
    public static void main(String[] args) {
        int[] arr = {1000};
        System.out.println(findTargetSumWays(arr, -1000));

    }

    public static int findTargetSumWays(int[] arr, int target) {
        int totalSum = 0, d = target;
        for (int num : arr) totalSum += num;

        if (((d + totalSum) & 1) == 1) return 0; // if it's not even both Subset combined not equal to whole array

        int newTarget = (d + totalSum) >> 1;
        return countOfSubsetSum(arr, newTarget);
    }

    private static int countOfSubsetSum(int[] arr, int target) {
        int[] t = new int[target + 1];
        t[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int sum = target; sum >= arr[i]; sum--) {
                t[sum] += t[sum - arr[i]];
            }
        }
        return t[target];
    }
}