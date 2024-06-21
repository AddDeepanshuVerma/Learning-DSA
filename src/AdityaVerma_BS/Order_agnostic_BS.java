package AdityaVerma_BS;

import java.util.Arrays;

public class Order_agnostic_BS {
    static int[] arr  = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int[] arr3 = {8};
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(arr2));
        int index = binarySearch(arr3, 7);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid = 0;
        /*if(end == 1){
            return arr[0] ==  target ? 0 : -1;
        }*/
        boolean ascOrder = arr[start] < arr[end];// considering array length is > 1
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                if(ascOrder) start = mid + 1;
                else end = mid -1;
            } else {
                if(ascOrder) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }


}
