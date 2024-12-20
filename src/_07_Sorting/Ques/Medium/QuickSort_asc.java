package _07_Sorting.Ques.Medium;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("All test cases passed")
public class QuickSort_asc {
    public static void main(String[] args) {
        int[] arr = {9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int PivotIndex = partition(arr, left, right);
            quickSort(arr, left, PivotIndex - 1);
            quickSort(arr, PivotIndex + 1, right);
        } else return;
    }

    public static int partition(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex + 1;// both fine int i = firstIndex;
        int j = high;
        while (i <= j) {
            if (arr[i] > pivot && arr[j] < pivot) swap(arr, i++, j--);
            if (arr[i] <= pivot) i++;
            if (arr[j] >= pivot) j--;
        }
        swap(arr, j, firstIndex);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}