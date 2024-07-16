package _06_Searching;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class Search_in_Rotated_Sorted_Array_33 {
    public static void main(String[] args) {
        System.out.println(finPivot1(new int[]{1}));
    }

    private static int finPivot1(int[] arr) {
//        if(arr.length == 1) return 0;
        int start = 0, end = arr.length-1, mid;
        while (start <= end ){
            mid = (start + end)/2;
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid-1;
            if(arr[start] <= arr[mid])
                start = mid + 1;
            else if(arr[mid] < arr[start])
                end = mid -1;
        }
        return -1;
    }
    private static int findPivot2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
