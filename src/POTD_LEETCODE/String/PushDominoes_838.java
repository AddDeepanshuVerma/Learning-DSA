package POTD_LEETCODE.String;

import java.util.Arrays;

// own story to code : passed all test cases
class PushDominoes_838 {
    public static String pushDominoes(String dominoes) {
        final int INF = (int) 1e6;
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();

        int[] right = new int[n];
        int[] left = new int[n];
        Arrays.fill(left, INF);
        Arrays.fill(right, INF);

        int time = 0;
        char prev = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                prev = 'R';
                time = 1;
                right[i] = 1;
                continue;
            } else if (arr[i] == '.' && prev == 'R') {
                right[i] = ++time;
            } else {
                prev = 'L';
            }
        }

        time = 0;
        prev = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                prev = 'L';
                time = 1;
                left[i] = 1;
                continue;
            } else if (arr[i] == '.' && prev == 'L') {
                left[i] = ++time;
            } else {
                prev = 'R';
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                ans.append('.');
            } else if (left[i] < right[i]) {
                ans.append('L');
            } else {
                ans.append('R');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String ans = pushDominoes(".L.R...LR..L..");
        System.out.println("ans = " + ans);
    }
}