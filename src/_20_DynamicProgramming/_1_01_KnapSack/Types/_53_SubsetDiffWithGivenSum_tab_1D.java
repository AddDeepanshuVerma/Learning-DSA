package _20_DynamicProgramming._1_01_KnapSack.Types;

import jdk.jfr.Description;

class _53_SubsetDiffWithGivenSum_tab_1D {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        System.out.println(countPartitions(4, 3, arr));
    }

    @Description("Method 1 : Here we are calculating all count for all subset till totalSum/2")
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int[] t = subSetSum(arr, totalSum >> 1);
        int count = 0;
        for (int sum = totalSum >> 1; sum >= 0; sum--) {
            if (t[sum] > 0) {
                int subSet1 = sum;
                int subSet2 = totalSum - subSet1;
                if (Math.abs(subSet2 - subSet1) == d) {
                    count = (count + t[sum]) % 1000_000_007;
                }
            }
        }
        return count;
    }

    private static int[] subSetSum(int[] arr, int target) {
        int[] t = new int[target + 1];
        t[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int sum = target; sum >= arr[i]; sum--) {
                t[sum] = (t[sum] + t[sum - arr[i]]) % 1000_000_007;
            }
        }
        return t;
    }
}