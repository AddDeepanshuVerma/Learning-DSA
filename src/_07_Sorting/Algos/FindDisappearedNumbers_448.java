package _07_Sorting.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindDisappearedNumbers_448 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[correct] == arr[i]) {
                i++;
            } else {
                swap(arr, correct, i);
            }
        }
        System.out.println(Arrays.toString(arr));
        // got the sorted array
        // now find the missing number
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    static void swap(int[] arr, int first, int end) {
        int temp = arr[first];
        arr[first] = arr[end];
        arr[end] = temp;
    }
}