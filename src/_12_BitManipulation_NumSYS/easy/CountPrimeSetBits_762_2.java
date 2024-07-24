package _12_BitManipulation_NumSYS.easy;

import java.util.HashSet;
import java.util.Set;

class CountPrimeSetBits_762_2 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    private static final Set<Integer> set = new HashSet<Integer>(Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23));
    private static final int[] arr = new int[1000001];
    static {
        for (int i = 0; i <= 1000000; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i >> 1];
            } else arr[i] = arr[i >> 1] + 1;
        }
    }
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(arr[i])) count++;
        }
        return count;
    }
}