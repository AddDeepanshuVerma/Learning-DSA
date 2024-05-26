package Searching_06;

import java.util.Arrays;

//passing all test cases using sliding window
public class MaxFrequency_1838_4 {
    public static void main(String[] args) {
        int[] nums = {3, 9, 6}; //expected 8
        System.out.println(maxFrequency(nums, 2));
        int[] nums2 = {9902, 9903, 9904, 9907, 9910, 9911, 9911, 9911, 9913, 9914, 9916, 9916, 9916, 9917, 9920, 9922, 9923, 9923, 9923, 9924, 9925, 9925, 9925, 9926, 9927, 9927, 9928, 9928, 9930, 9930, 9930, 9930, 9932, 9932, 9933, 9934, 9935, 9935, 9936, 9937, 9938, 9938, 9943, 9945, 9945, 9946, 9947, 9952, 9952, 9954, 9954, 9957, 9959, 9963, 9964, 9964, 9966, 9970, 9972, 9972, 9973, 9973, 9974, 9975, 9975, 9975, 9977, 9977, 9981, 9982, 9983, 9983, 9985, 9985, 9985, 9986, 9988, 9990, 9990, 9993, 9994, 9995, 9996, 9997, 10000}; //expected 8
        System.out.println(maxFrequency(nums2, 3056));
    }

    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int s = 0, e = 0, res = 0;
        long sum = 0;
        while (e < arr.length) {
            sum = sum + arr[e];
            while ((long) (e - s + 1) * arr[e] > sum + k) {
                sum -= arr[s];
                s++;
            }
            res = Math.max(res, e - s + 1);
            e++;
        }
        return res;
    }
}
