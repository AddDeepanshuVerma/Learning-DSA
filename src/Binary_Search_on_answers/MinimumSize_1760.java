package Binary_Search_on_answers;

import java.util.Arrays;

class MinimumSize_1760 {
    public static void main(String[] args) {
        int[] arr = {7, 17};
        System.out.println(minimumSize(arr, 2));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
//        int end = (int) 1E9;
        int end = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isValid(nums, mid, maxOperations)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int mid, int maxOperations) {
        int count = 0;
        for (int num : arr) {
            count += (num - 1) / mid;
            if (count > maxOperations) return false;
        }
        return count <= maxOperations;
    }

    private static boolean isValid2(int[] arr, int mid, int maxOperations) {
        int count = 0;
        for (int num : arr) {
            if (num > mid) {
                count += (num / mid - 1);
                if (num % mid != 0) count++;
            }
        }
        return count <= maxOperations;
    }
}