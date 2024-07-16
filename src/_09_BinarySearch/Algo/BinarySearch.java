package _09_BinarySearch.Algo;

import java.util.Arrays;

public class BinarySearch {
    static int[] arr = {0,1,2, 3, 4, 5, 6, 7, 8};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(arr, 5);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


}
