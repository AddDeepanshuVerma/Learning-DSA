package AdityaVerma_BinarySearch;

import java.util.Arrays;
import java.util.List;

public class FirstLastIndex {
    static int[] arr = {0, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8};
    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        System.out.println("first index " + list.indexOf(3));
        System.out.println("last index " + list.lastIndexOf(3));
//        int index = binarySearch(arr, 5);
//        System.out.println(index);
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
