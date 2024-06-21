package Sorting_07.Ques.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class findErrorNums_645 {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i--, correctIndex);
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 != i) {
                return new int[]{arr[i], i + 1};
            }
        }
        return null;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}