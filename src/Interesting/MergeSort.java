package Interesting;

import Random.AntonClass;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 6, 2, 1, 0};
        int[] arr2 = {9, 8, 7, 6, 7, 8, 7, 6, 5, 4, 5, 6, 7, 6, 5, 4, 33, 2};
        int[] res = mergerSort(arr2);
        System.out.println(Arrays.toString(res));
    }

    private static int[] mergerSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length >>> 1;
        int[] left = mergerSort(Arrays.copyOfRange(arr, 0, mid));
        int[] righ = mergerSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, righ);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) res[k++] = left[i++];
            else res[k++] = right[j++];
        }
        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];

        return res;
    }
}
