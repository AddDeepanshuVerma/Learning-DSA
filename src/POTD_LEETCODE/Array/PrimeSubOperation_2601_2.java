package POTD_LEETCODE.Array;

class PrimeSubOperation_2601_2 {
    public static void main(String[] args) {
        int[] nums = {998, 2};
        int[] nums2 = {2, 2};
        int[] nums3 = {5, 8, 3};
//        System.out.println(primeSubOperation(nums));
//        System.out.println(primeSubOperation(nums2));
        System.out.println(primeSubOperation(nums3));
    }

    static boolean[] prime;

    static {
        int n = 1000;
        prime = new boolean[n + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= n + 1; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static boolean primeSubOperation(int[] nums) {
        int prev = -1;
        for (int num : nums) {
            int newVal = find(num, prev);
            if (newVal == -1) return false;
            prev = newVal;
        }
        return true;
    }

    private static int find(int num, int prev) {
        if (prev >= num) return -1;
        for (int i = num - 1; i >= 0; i--) {
            if (!prime[i] && (num - i) > prev) {
                return num - i;
            }
        }
        return num > prev ? num : -1;
    }
}