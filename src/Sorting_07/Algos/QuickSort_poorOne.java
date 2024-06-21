package Sorting_07.Algos;

import jdk.jfr.Description;
import java.util.Arrays;

@Description("All test cases passed")
public class QuickSort_poorOne {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    @Description("watch src/Sorting_07/Algos/QuickSort_asc.java for more clarity")
    static int partition(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex; // here i = firstIndex + 1; will not work
        int j = high;
        while (i < j) {  // here (i <= j) will not work
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= firstIndex + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, firstIndex, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
