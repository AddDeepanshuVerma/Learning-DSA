package POTD_LEETCODE.Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LenLongestFibSubseq_873_4 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 10, 11, 12, 18, 23, 35};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
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