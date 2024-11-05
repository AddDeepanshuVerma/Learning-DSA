package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class FindNumberOfLIS_673 {
    public static void main(String[] args) {
        FindNumberOfLIS_673 obj = new FindNumberOfLIS_673();
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(obj.findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for (int[] each : arr) {
            Arrays.fill(each, 1);
        }

        int count = 0, max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (arr[j][0] + 1 > arr[i][0]) {
                        arr[i][0] = arr[j][0] + 1;
                        arr[i][1] = arr[j][1];
                    } else if (arr[j][0] + 1 == arr[i][0]) {
                        arr[i][1] += arr[j][1];
                    }
                    max = Math.max(max, arr[i][0]);
                }
            }
        }

        if (max == 1) return n;

        for (int[] ints : arr) {
            if (ints[0] == max) {
                count += ints[1];
            }
        }

        return count;
    }

    // not working for all TC
    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int count = 1, max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    arr[i] = Math.max(arr[i], 1 + arr[j]);
                    if (arr[i] == max) {
                        count++;
                    } else if (arr[i] > max) {
                        max = arr[i];
                        count = 1;
                    }
                }
            }
        }
        return count;
    }
}