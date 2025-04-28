package _06_Searching;

import java.util.Arrays;
// passing all test cases
public class MaxFrequency_1838_3 {
    public static void main(String[] args) {
        int[] nums = {9902, 9903, 9904, 9907, 9910, 9911, 9911, 9911, 9913, 9914, 9916, 9916, 9916, 9917, 9920, 9922, 9923, 9923, 9923, 9924, 9925, 9925, 9925, 9926, 9927, 9927, 9928, 9928, 9930, 9930, 9930, 9930, 9932, 9932, 9933, 9934, 9935, 9935, 9936, 9937, 9938, 9938, 9943, 9945, 9945, 9946, 9947, 9952, 9952, 9954, 9954, 9957, 9959, 9963, 9964, 9964, 9966, 9970, 9972, 9972, 9973, 9973, 9974, 9975, 9975, 9975, 9977, 9977, 9981, 9982, 9983, 9983, 9985, 9985, 9985, 9986, 9988, 9990, 9990, 9993, 9994, 9995, 9996, 9997, 10000}; //expected 8
        System.out.println(maxFrequency(nums, 3056));
    }

    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int maxFrequency = -1;
        long[] preFixSum = findPreFix(arr);
        for (int i = 0; i < arr.length; i++) {
            int currFrequency = frequency(arr, k, i,preFixSum);
            maxFrequency = Math.max(currFrequency, maxFrequency);
        }
        return maxFrequency;
    }


    public static int frequency(int[] arr, int k, int targetIndex, long[] preFixSum) {
        int start = 0;
        int end = targetIndex;
        int mid = 0;
        int ans = -1;
        while (start <= end) {
            mid = (start + end) >> 1;
            long windowSum = (long) (targetIndex - mid + 1) * arr[targetIndex];
            long sumAfterAddingK = preFixSum[targetIndex] - preFixSum[mid] + arr[mid] + k;
//            int sumAfterAddingK = sum(arr, mid, targetIndex) + k;
            if (windowSum > sumAfterAddingK) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return targetIndex - ans + 1;
    }

    private static long[] findPreFix(int[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] + res[i];
        }
        return res;
    }


    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= end && i >= start) {
                sum += arr[i];
            }
        }
        return sum;
    }

}
