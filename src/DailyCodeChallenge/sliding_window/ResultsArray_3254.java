package DailyCodeChallenge.sliding_window;

import java.util.Arrays;

class ResultsArray_3254 {
    public static void main(String[] args) {
        ResultsArray_3254 obj = new ResultsArray_3254();
        int[] num = {1, 3, 4};
        System.out.println(Arrays.toString(obj.resultsArray(num, 2)));
    }

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int i = 0, j = 0;
        while (j < n) {
            if (j - i + 1 == k) {
                ans[i] = isSortedAndConsecutive(nums, i, j) ? nums[j] : -1;
                i++;
            }
            j++;
        }
        return ans;
    }

    private boolean isSortedAndConsecutive(int[] nums, int i, int j) {
        for (int k = i + 1; k <= j; k++) {
            if (nums[k] - 1 != nums[k - 1]) return false;
        }
        return true;
    }
}