package DailyCodeChallenge;

import javax.naming.AuthenticationNotSupportedException;
import java.util.Arrays;

class MinSwaps_2134 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(minSwaps(arr));
    }

    public static int minSwaps2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums)
            sum += num;

        int i = 0, n = nums.length;
        int countOfOne = 0;

        for (int j = 0; j < n * 2; j++) {
            countOfOne += nums[j % n];
            if (j - i >= sum) {
                countOfOne = countOfOne - nums[i % n];
                i++;
            }
            ans = Math.max(ans, countOfOne);
        }
        return sum - ans;
    }

    public static int minSwaps(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }

        int i = 0;
        int countOfOne = 0;
        for (int j = 0; j < arr.length; j++) {
            countOfOne += arr[j];
            if (j - i >= sum) {
                countOfOne = countOfOne - arr[i];
                i++;
            }
            ans = Math.max(ans, countOfOne);
        }
        return sum - ans;
    }
}