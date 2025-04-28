package POTD_LEETCODE.Array;

class MinOperations_3375 {
    public int minOperations(int[] nums, int k) {
        int[] arr = new int[101];
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            arr[num]++;
            min = Math.min(min, num);
        }
        if (min < k) return -1;// edge case

        // count of distinct elements > k will be our answer
        int count = 0;
        for (int i = k + 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public int minOperations2(int[] nums, int k) {
        boolean[] arr = new boolean[101];
        for (int num : nums) arr[num] = true;

        // count of distinct elements > k will be our answer
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                if (i < k) return -1;
                if (i > k) count++;
            }
        }
        return count;
    }
}