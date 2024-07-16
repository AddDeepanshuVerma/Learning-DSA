package _07_Sorting.Ques.Medium;

import java.util.Arrays;

class threeSumClosest_16 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 100000;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0;
            while (j < k) {
                sum =  nums[i] + nums[j] +nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }

}