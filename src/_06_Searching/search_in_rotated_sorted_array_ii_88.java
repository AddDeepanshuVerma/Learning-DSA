package _06_Searching;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class search_in_rotated_sorted_array_ii_88 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1} , 0));
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1} , 2));
    }


//    2,5,6,0,0,1,2
    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length-1, mid;
        while (start <= end ){
            mid = (start + end)/2;
            if(arr[mid] == target ) return mid;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                ++start;
                --end;
                continue;
            }
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid-1;
            if(arr[start] <= arr[mid])
                start = mid + 1;
            else if(arr[mid] < arr[start])
                end = mid -1;
        }
        return -1;
    }
}
