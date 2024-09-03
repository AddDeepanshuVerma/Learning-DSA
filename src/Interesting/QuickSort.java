package Interesting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 5, 5, 5, 5, 6, 6, 7, 8, 9};
//        sortArray(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start <= end) {
            int partition = partition(arr, start, end);
            quickSort(arr, 0, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            if (arr[i] > pivot && arr[j] < pivot) swap(arr, i++, j--);
            if (arr[i] <= pivot) i++;
            if (arr[j] >= pivot) j--;
        }
        swap(arr, start, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
