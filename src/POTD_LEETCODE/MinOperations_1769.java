package POTD_LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinOperations_1769 {
    public static void main(String[] args) {
        String s = "001011";
        System.out.println(Arrays.toString(minOperations3(s)));
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        // need to store the indexes where 1 is available
        List<Integer> list = new ArrayList<>();
        char[] arr = boxes.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') list.add(i);
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int index : list) {
                count += Math.abs(index - i);
            }
            ans[i] = count;
        }
        return ans;
    }

    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        char[] arr = boxes.toCharArray();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == '1') {
                    count += Math.abs(j - i);
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    // optimal approach : specific for the q type O(n)
    public static int[] minOperations3(String boxes) {
        char[] arr = boxes.toCharArray();

        int n = arr.length;
        int[] ans = new int[n];

        int prefix = 0, sumOfPrefix = 0;

        for (int i = 0; i < n; i++) {
            ans[i] = sumOfPrefix;
            prefix += arr[i] - '0';

            sumOfPrefix += prefix;
        }
        prefix = 0;
        sumOfPrefix = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += sumOfPrefix;
            prefix += arr[i] - '0';

            sumOfPrefix += prefix;
        }
        return ans;
    }
}