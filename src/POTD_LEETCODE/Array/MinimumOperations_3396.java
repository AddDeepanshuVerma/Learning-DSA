package POTD_LEETCODE.Array;

class MinimumOperations_3396 {
    public static int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        int lastIdx = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[nums[i]]++ > 0) {
                lastIdx = i;
                break;
            }
        }
        if (lastIdx == -1) return 0;
        int len = lastIdx + 1;
        return (len / 3) + (len % 3 != 0 ? 1 : 0);
    }

    public static int minimumOperations2(int[] nums) {
        int[] arr = new int[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[nums[i]]++ > 0) {
                i++;
                return (i / 3) + (i % 3 != 0 ? 1 : 0);
            }
        }
        return 0;
    }

    public static int minimumOperations3(int[] nums) {
        int[] arr = new int[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[nums[i]]++ > 0) {
                return (int) Math.ceil((i + 1) / 3.0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 4, 4};
        int count = minimumOperations(nums);
        System.out.println("count = " + count);
    }
}