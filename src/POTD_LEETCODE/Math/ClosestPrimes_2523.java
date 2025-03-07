package POTD_LEETCODE.Math;

import java.util.Arrays;

class ClosestPrimes_2523 {
    static int[] prime;

    static {
        // calculate all isPrime numbers from 0 till 1e6
        boolean[] isPrime = new boolean[100_00_00 + 1];
        Arrays.fill(isPrime, true); // considering all numbers are isPrime initially (0 is exceptional)

//        int maxLimit = (int) Math.sqrt(isPrime.length) + 1;
//        for (int i = 2; i <= maxLimit; i++) {
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) { // is ith index is isPrime, mark all its table to not isPrime
                for (int j = i * i; j < isPrime.length; j += i) { // 1 more optimization can be done here
                    isPrime[j] = false;
                }
            }
        }

        int primeCount = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }

        prime = new int[primeCount];
        int j = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                prime[j++] = i;
            }
        }
    }


    public static int[] closestPrimes(int left, int right) {
        // as we have got all the prime number now simple run a loop from end to first to get the lowest index in cas of multiple answers
        int lRange = greaterEqual(left);
        int rRange = lesserEqual(right);
        if (lRange >= rRange) return new int[]{-1, -1};

        int first = -1;
        int second = -1;
        int min = Integer.MAX_VALUE;
        for (int i = rRange; i > lRange; i--) {
            if (min >= prime[i] - prime[i - 1]) {
                min = prime[i] - prime[i - 1];
                first = prime[i - 1];
                second = prime[i];
            }
        }
        return new int[]{first, second};
    }

    private static int lesserEqual(int val) {
        int start = 0;
        int end = prime.length - 1;
        int ans = start;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (prime[mid] <= val) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static int greaterEqual(int val) {
        int start = 0;
        int end = prime.length - 1;
        int ans = end;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (prime[mid] >= val) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = closestPrimes(999998, 1000000);
        System.out.println(Arrays.toString(ans));
    }
}