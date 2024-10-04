package _07_Sorting.Algos;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("All test cases passed")
public class QuickSort_asc_shortForm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 3, 2, 54, 6, 7, 8, 8, 5, 3, 2, 3, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        } else {
            return;// here we did nothing to array and returned as there was single element
        }
    }

    public static int partition(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex;// both fine int i = firstIndex + 1 ;
        int j = high;
        while (i <= j) {
            /*if (arr[i] > pivot && arr[j] < pivot) swap(arr, i++, j--);
            else if (arr[i] <= pivot) i++;
            else if (arr[j] >= pivot) j--;*/
            if (arr[i] >= pivot && arr[j] <= pivot) swap(arr, i++, j--);
            else if (arr[i] <= pivot) i++;
            else if (arr[j] >= pivot) j--;
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