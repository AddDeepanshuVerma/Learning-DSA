package DailyCodeChallenge.BinarySearch;

import java.util.Arrays;

class MinimizedMaximum_2064 {
    public static void main(String[] args) {
        int[] arr = {5, 7};
        System.out.println(minimizedMaximum(2, arr));
    }

    public static int minimizedMaximum(int n, int[] arr) {
        int ans = -1;
        int start = 0, end = Arrays.stream(arr).max().getAsInt();

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (canSpendAll(arr, mid, n)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private static boolean canSpendAll(int[] arr, int mid, int n) {
        int count = 0;
        for (int num : arr) {
            count += num / mid;
            if (num % mid != 0) {
                count++;
            }
        }
        return count <= n;
    }

    private static boolean canSpendAll2(int[] arr, int mid, int n) {
        int count = 0;
        for (int num : arr) {
            count += (int) Math.ceil(num / (mid * 1.0));
        }
        return count <= n;
    }

    private static boolean canSpendAll3(int[] arr, int mid, int n) {
        int count = 0;
        for (int num : arr) {
            count += (int) Math.ceil(num / (mid * 1.0));
            if (count > n) return false;
        }
        return true;
    }

    private static boolean canSpendAll4(int[] arr, int mid, int n) {
        int count = 0;
        for (int num : arr) {
            count += num / mid;
            if (num % mid != 0) count++;

            if (count > n) return false;
        }
        return true;
    }
}