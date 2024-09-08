package _07_Sorting.Algos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1,4,3,2,54,6,7,8,8,5,3,2,3,5};
        int[] res = mergeSort(arr);
        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;
        int mid = arr.length >> 1;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) res[k++] = first[i++];
            else res[k++] = second[j++];
        }
        while (i < first.length) res[k++] = first[i++];
        while (j < second.length) res[k++] = second[j++];
        return res;
    }
}
