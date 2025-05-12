package POTD_LEETCODE.Dynamic_Programming;

import java.util.Arrays;
import java.util.HashSet;

//Creating all permutation with !n and for each permutation, running the balanced check loop hence N more === !n * n
class CountBalancedPermutations_3343 {
    int count;
    int totalSum;

    public int countBalancedPermutations(String num) {
        count = 0;
        for (char ch : num.toCharArray()) totalSum += ch - '0';
        if ((totalSum & 1) == 1) return 0;

        dfs(0, num.length(), num.toCharArray());
        return count;
    }

    private void dfs(int i, int n, char[] arr) {
        if (i >= n - 1) {
            System.out.println("arr = " + Arrays.toString(arr));
            if (isBalanced(arr)) {
                count++;
            }
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < n; j++) {
            if (set.contains(arr[j])) continue;
            set.add(arr[j]);
            swap(j, i, arr);
            dfs(i + 1, n, arr);
            swap(j, i, arr);
        }
    }

    private boolean isBalanced(char[] arr) {
        int evenSum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            evenSum += arr[i] - '0';
        }
        return totalSum == (evenSum << 1);
    }

    private void swap(int i, int j, char[] arr) {
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        var obj = new CountBalancedPermutations_3343();
        String num = "022";
        int ans = obj.countBalancedPermutations(num);
        System.out.println("ans = " + ans);
    }
}