package _07_Sorting.Algos;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 3, 3, 2, 2, 2, 1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid, end);
        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] res = new int[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                res[k] = arr[i];
                i++;
            } else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            res[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            res[k] = arr[j];
            j++;
            k++;
        }
        System.arraycopy(res, 0, arr, start, res.length);
    }
}
