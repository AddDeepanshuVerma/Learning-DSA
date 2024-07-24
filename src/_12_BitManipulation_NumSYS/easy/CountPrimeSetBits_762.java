package _12_BitManipulation_NumSYS.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CountPrimeSetBits_762 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    private static final Set<Integer> set = new HashSet<Integer>(Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23));

    public static int countPrimeSetBits(int left, int right) {
        // create and array with from 0 till right element
        // and put the values of 1's in binary representation of their index value
        int[] arr = new int[right + 1];
        for (int i = 0; i <= right; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i >> 1];
            } else arr[i] = arr[i >> 1] + 1;
        }
        // Check in the give range how many prime number are there
        int count = 0;
        for (int i = left; i <= right; i++) {
//            if (isPrime(arr[i])) count++;
            if (set.contains(arr[i])) count++;
        }
        return count;
    }


    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; (i * i) <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}