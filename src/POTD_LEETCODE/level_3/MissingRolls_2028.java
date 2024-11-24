package POTD_LEETCODE.level_3;

import java.util.Arrays;

class MissingRolls_2028 {
    public static void main(String[] args) {
        int[] arr = {};
        MissingRolls_2028 obj = new MissingRolls_2028();
        System.out.println(Arrays.toString(obj.missingRolls(arr, 2, 53)));
    }

    public int[] missingRolls_0(int[] rolls, int mean, int n) {
        int sumA = 0;
        for (int roll : rolls) sumA += roll;
        int totalLength = rolls.length + n;
        int sumB = (mean * totalLength) - sumA;

        if ((sumB * 1.0) / n > 6.0 || sumB < 0 || sumB / n == 0) {
            return new int[0];
        }

        int eachElement = sumB / n;
        int carry = sumB % n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = eachElement + (carry-- > 0 ? 1 : 0);
        }
        return ans;
    }

    public int[] missingRolls(int[] rolls, int mean, int missingLength) {
        int totalSum = (rolls.length + missingLength) * mean;
        int sumA = 0;
        for (int roll : rolls) sumA += roll;

        int missingSum = totalSum - sumA;
        if (isInvalid(missingLength, missingSum)) return new int[0];

        int[] ans = new int[missingLength];
        int eachElement = missingSum / missingLength;
        int carry = missingSum % missingLength;

        for (int i = 0; i < missingLength; i++) {
            ans[i] = eachElement + (i < carry ? 1 : 0);
        }
        return ans;
    }

    private static boolean isInvalid(int missingLength, int missingSum) {
        return missingSum < missingLength || missingSum > 6 * missingLength;
    }

}