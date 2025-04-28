package POTD_LEETCODE.prefix;

class NumOfSubarrays_1524 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays2(arr));
    }

    public static int numOfSubarrays(int[] arr) {
        int mod = 1000_000_007;
        int prefix = 0, evenCount = 0, oddCount = 0;
        int ans = 0;
        for (int val : arr) {
            prefix += val;
            if ((prefix & 1) == 1) {
                oddCount = (oddCount + 1) % mod;
                ans = (ans + evenCount + 1) % mod;
            } else {
                evenCount = (evenCount + 1) % mod;
                ans = (ans + oddCount) % mod;
            }
        }
        return ans % mod;
    }

    public static int numOfSubarrays2(int[] arr) {
        int mod = 1000_000_007;
        long evenCount = 1, oddCount = 0;
        long ans = 0, prefix = 0;
        for (int val : arr) {
            prefix += val;
            if ((prefix & 1) == 1) { // prefix sum is ODD
                oddCount++;
                ans += evenCount;
            } else {                 // prefix is even
                evenCount++;
                ans += oddCount;
            }
        }
        return (int) (ans % mod);
    }
}