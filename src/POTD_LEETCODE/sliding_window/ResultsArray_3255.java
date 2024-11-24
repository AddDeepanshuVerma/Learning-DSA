package POTD_LEETCODE.sliding_window;

import java.util.Arrays;

class ResultsArray_3255 {
    public static void main(String[] args) {
        ResultsArray_3255 obj = new ResultsArray_3255();
        int[] num = {1, 2, 3, 4, 3, 2, 5};
        System.out.println(Arrays.toString(obj.resultsArray(num, 3)));
    }

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int i = 0, j = 0;
        int count = 1;
        while (j < n) {
            if (j != 0) {
                if (nums[j] - 1 == nums[j - 1]) {
                    count++;
                } else count = 1;
            }

            if (j - i + 1 == k) {
                ans[i] = count >= k ? nums[j] : -1;
                i++;
            }
            j++;
        }
        return ans;
    }
}