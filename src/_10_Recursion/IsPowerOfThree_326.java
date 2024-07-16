package _10_Recursion;

import java.util.Arrays;

class IsPowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public boolean isPowerOfThree2(int n) {
        int[] allPowerOfThree = new int[]{
                1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
                1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467
        };
        return Arrays.binarySearch(allPowerOfThree, n) >= 0;
    }
}