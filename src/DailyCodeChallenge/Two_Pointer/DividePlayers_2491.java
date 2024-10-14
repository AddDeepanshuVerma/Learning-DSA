package DailyCodeChallenge.Two_Pointer;

import Interesting.MergeSort;

import java.util.Arrays;

class DividePlayers_2491 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 3, 2, 54, 6, 7, 8, 8, 5, 3, 2, 3, 5};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static long dividePlayers(int[] skill) {
        int n = skill.length;
//        Arrays.sort(skill);
        skill = mergeSort(skill);
        long sum = skill[0] + skill[n - 1];
        long ans = 0;

        int i = 0, j = n - 1;
        while (i < j) {
            long first = skill[i++], second = skill[j--];
            if (sum == first + second) ans += first * second;
            else return -1;
        }
        return ans;
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length >> 1;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeTwoSortedArray(left, right);
    }

    private static int[] mergeTwoSortedArray(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) ans[k++] = left[i++];
            else ans[k++] = right[j++];
        }
        while (i < left.length) ans[k++] = left[i++];
        while (j < right.length) ans[k++] = right[j++];
        return ans;
    }



}