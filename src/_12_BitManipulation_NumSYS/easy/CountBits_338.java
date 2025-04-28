package _12_BitManipulation_NumSYS.easy;

import java.util.Arrays;

class CountBits_338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits2(2)));

    }

    private static int[] countBits3(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + 1;
            }
        }
        return arr;
    }

    private static int[] countBits2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int count = arr[i >> 1];
            arr[i] = (i & 1) == 1 ? ++count : count;
        }
        return arr;
    }


    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = hammingWeight(i);
        }
        return arr;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}