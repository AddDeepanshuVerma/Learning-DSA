package Sorting_07.Algos;

import java.util.Arrays;

class SortArray_912 {
    static int[] sortArray(int[] arr) {
        int n = arr.length;
        if (arr.length == 1) {
            return arr;
        }
        int mid = n >> 1;
        int[] left = sortArray(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(arr, mid, n));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                res[k] = first[i];
                i++;
            } else {
                res[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            res[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            res[k] = second[j];
            j++;
            k++;
        }
        return res;
    }
}