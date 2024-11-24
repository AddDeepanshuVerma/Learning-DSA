package POTD_LEETCODE.SubArray;

public class Helper {
    public static void main(String[] args) {
        int[] nums = {26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3};
        int k = 3;
        find(nums, k);

    }

    private static void find(int[] nums, int k) {
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (j - i + 1 > k) {
                sum -= nums[i++];
            }
            if (j - i + 1 == k) {
                int temp = 0;
                for (int l = i; l <= j; l++) {
                    temp += nums[l];
                    System.out.print(nums[l] + " ");
                }
                System.out.print(", sum = " + temp + " with " + ((225 - temp) % 26 == 0));

                System.out.println();
            }
        }
    }
}
