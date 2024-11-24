package POTD_LEETCODE.SubSequence;

import java.util.Arrays;

class LengthOfLIS_300_BottomUP {
    public static void main(String[] args) {
        LengthOfLIS_300_BottomUP obj = new LengthOfLIS_300_BottomUP();
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(obj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        /* We will go for a bottom up approach :
         * Here create an array, that will represent Longest Increasing Subsequence for each index
         * Steps :
         *   1. As all elements are by default minimum 1 length of LIS hence fill the resultant arr with 1
         *   2.  now for each element from i : 0 -> n, do a loop from 0 to i and search an element which is
         *       lower than current soThat current element can be added to end of this element which will increment
         *       the count of resultant index for this curr element
         *   3. Later/Meanwhile we can store what's the max we got in resultant array as the required answer.
         *   4. minimum possible answer is 1 as 1 is always possible
         * */
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, 1);

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                    ans = Math.max(ans, res[i]);
                }
            }
        }
//        System.out.println("res = " + Arrays.toString(res));
        return ans;
    }
}