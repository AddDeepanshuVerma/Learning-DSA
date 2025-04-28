package _07_Sorting.Algos;

import java.util.Arrays;

class QuickSort_asc_gfg {

    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 7, 8, 5, 1, 2, 0, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    static int partition(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex;
        int j = high;
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
            }
        }
        swap(arr, firstIndex, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}