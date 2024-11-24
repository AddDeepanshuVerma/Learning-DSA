package _20_DynamicProgramming._1_01_KnapSack.Types;

class _61_TargetSum_tab_1D {
    public static void main(String[] args) {
        int[] arr = {1000};
        System.out.println(findTargetSumWays(arr, -1000));

    }

    public static int findTargetSumWays(int[] arr, int target) {
        /*
        You are given an integer array nums and an integer target.
        You want to build an expression out of nums by adding one of the symbols '+' and '-' before
        each integer in nums and then concatenate all the integers.
        For example,if nums = [2, 1],you can add a '+' before 2 and a '-' before 1 and concatenate them to
        build the expression "+2-1".Return the number of different expressions that you can build, which evaluates to target.
        */

        /*
         * They are simply asking about subset sum difference with given target
         * Means : (+10 + 12 + 13 + 14)  - (+5 + 6 + 7) = target
         * Means : (subset 1 sum)  - (subset 2 sum) = target
         *  */
        int totalSum = 0, d = target;
        for (int num : arr) totalSum += num;

        int[] t = subSetSum(arr, totalSum >> 1);
        int count = 0;
        for (int sum = totalSum >> 1; sum >= 0; sum--) {
            if (t[sum] > 0) {
                int subSet1 = sum;
                int subSet2 = totalSum - subSet1;
                if (subSet2 - subSet1 == d) {
                    count = count + t[sum];
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
                t[sum] += t[sum - arr[i]];
            }
        }
        return t;
    }
}