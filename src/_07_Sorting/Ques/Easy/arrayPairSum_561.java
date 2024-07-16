package _07_Sorting.Ques.Easy;

import java.util.Arrays;

class arrayPairSum_561 {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
//        for (int i = nums.length - 1; i >= 0; i -= 2) {
//            sum += Math.min(nums[i], nums[i - 1]);
//        }
        for (int i = nums.length-1; i >= 0; i -= 2) {
            sum += nums[i-1];
        }
        return sum;
    }

    private static int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2)
        {
            sum +=nums[i];
        }
        return sum;
    }


}