package _12_BitManipulation_NumSYS.easy;

import java.util.Arrays;

class Decode_1720 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(decode2(arr, 1)));
    }

    private static int[] decode2(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[++n];
        ans[0] = first;
        for (int i = 1; i < n; i++)
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        return ans;
    }

    public static int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}