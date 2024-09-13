package _11_BackTracking.Algo1;

import jdk.jfr.Description;

@Description("Does not work due to call by value usage on line 18")
public class LargestNumberIn_K_Swaps_3 {
    public static void main(String[] args) {
        String str = "123";
        int k = 2;
        System.out.println(LargestNumber(str, k));
    }

    private static String LargestNumber(String str, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        solve(str.toCharArray(), k, 0, sb);
        // sb is not updating while being pass by reference value
        // found the issue, was in new keyword at line 26
        return sb.toString();
    }

    private static void solve(char[] arr, int k, int start, StringBuilder max) {
        if ((start == arr.length - 1) || k == 0) {
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > arr[start]) {
                swap(arr, start, i);
                max = compare(max, new StringBuilder(String.valueOf(arr)));
                solve(arr, k - 1, start + 1, max);
                swap(arr, start, i);
            }
        }
        solve(arr, k, start + 1, max);
    }

    private static StringBuilder compare(StringBuilder s1, StringBuilder s2) {
        return s1.compareTo(s2) > 0 ? s1 : s2;
    }

    private static void swap(char[] arr, int start, int i) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }

}
