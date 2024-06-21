package Sorting_07.Algos;

import jdk.jfr.Description;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Description("each element has to be in the range of [0, n]; where n is length of array")
    static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                // decrement i as we want to leave this index if and only if condition is satisfied
                // So we again set the loop to check it again
                swap(arr, i--, correctIndex);
            }
        }
        /*for (int i = 0; i < arr.length; ) {
            int correctIndex = arr[i] - 1;
            if (arr[i] == arr[correctIndex]) {
                i++;
            } else {
                swap(arr, i, correctIndex);
            }
        }*/
    }

    private static void swap(int[] arr, int first, int end) {
        int temp = arr[first];
        arr[first] = arr[end];
        arr[end] = temp;
    }
}
