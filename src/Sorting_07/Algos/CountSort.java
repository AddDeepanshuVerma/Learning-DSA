package Sorting_07.Algos;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {9, 9, 8, 7, 6, 5, 5, 3, 3, 3, 2, 1};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] array) {
        if (array == null || array.length <= 1) return;
        int max = array[0];
        for (int num : array) max = Math.max(max, num);

        int[] countArray = new int[max + 1];
        for (int num : array) countArray[num]++;

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                array[index] = i;
                index++;
                countArray[i]--;
            }
        }

    }
}
