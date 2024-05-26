package Searching_06;

import java.util.Arrays;
// not passing all test cases
public class MaxFrequency_1838 {
    public static void main(String[] args) {
        int[] nums = {9902, 9903, 9904, 9907, 9910, 9911, 9911, 9911, 9913, 9914, 9916, 9916, 9916, 9917, 9920, 9922, 9923, 9923, 9923, 9924, 9925, 9925, 9925, 9926, 9927, 9927, 9928, 9928, 9930, 9930, 9930, 9930, 9932, 9932, 9933, 9934, 9935, 9935, 9936, 9937, 9938, 9938, 9943, 9945, 9945, 9946, 9947, 9952, 9952, 9954, 9954, 9957, 9959, 9963, 9964, 9964, 9966, 9970, 9972, 9972, 9973, 9973, 9974, 9975, 9975, 9975, 9977, 9977, 9981, 9982, 9983, 9983, 9985, 9985, 9985, 9986, 9988, 9990, 9990, 9993, 9994, 9995, 9996, 9997, 10000}; //expected 8
        System.out.println(maxFrequency(nums, 3056));
    }

    public static int maxFrequency(int[] nums, int k) {
        int maxCount = 1;
        int tempK = k;
        if(nums.length <= 1 ) return maxCount;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            k = tempK;
//            if(maxCount == nums.length-1 || nums.length -1- i <= maxCount) return maxCount;
            int currCount = 1;
            for (int j = i+1; j < nums.length; j++) {
                k = k - ((nums[j]- nums[j-1])*j);
                if (k >= 0) {
                    ++currCount;
                    maxCount = Math.max(maxCount, currCount);
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }
}
