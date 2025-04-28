package POTD_LEETCODE.Dynamic_Programming;

import java.util.HashSet;
import java.util.Set;

class LenLongestFibSubseq_873_topDown {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        System.out.println(lenLongestFibSubseq(arr));
        System.out.println(lenLongestFibSubseq2(arr));
    }

    private static int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int first = arr[i], second = arr[j];
                int count = 2;
                while (set.contains(first + second)) {
                    count++;
                    second = second + first;
                    first = second - first;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans > 2 ? ans : 0;
    }

    public static int lenLongestFibSubseq2(int[] arr) {
        Set<Integer> s = new HashSet<Integer>(arr.length + 1);
        int n = arr.length;
        int ans = 2;
        for (int k : arr) s.add(k);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j];
                int curr = 2;
                while (s.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    curr++;
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans == 2 ? 0 : ans;

    }
}