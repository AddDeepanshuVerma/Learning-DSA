package _07_Sorting.Ques.Medium;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("All test cases passed")
public class QuickSort_desc {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3};
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
        int i = firstIndex + 1;// both fine int i = firstIndex ;
        int j = high;
        while (i <= j) {
            if (arr[i] < pivot && arr[j] > pivot) swap(arr, i++, j--);
            if (arr[i] >= pivot) i++;
            if (arr[j] <= pivot) j--;
        }
        swap(arr, j, firstIndex);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

// don't know why but taking way long time in leetcode might be chatGPT plagiarism
    public static int chat_GPT(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex + 1; // both fine int i = firstIndex ;
        int j = high;
        while (i <= j) {
            while (arr[i] >= pivot && i <= j) i++;
            while (arr[j] < pivot && i <= j) j--;
            if (i <= j) swap(arr, i++, j--);
        }
        swap(arr, j, firstIndex); // Place pivot to correct position
        return j;
    }
}