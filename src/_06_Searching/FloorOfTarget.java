package _06_Searching;

public class FloorOfTarget {
    public static void main(String[] args) {
        int[] sArr = {1,2,4,4,7,10};
        System.out.println(binarySearch(sArr,1));
    }

    private static long binarySearch(int[] arr, long target) {
        int start = 0,
                end = arr.length-1,
                mid = 0;
//        if(target <= arr[0]) return arr[0];
//        if(target >= arr[end]) return arr[end];
        while (start +1 < end) {
            mid = start + (end - start)/2;
            if (arr[mid] < target) {
                start = mid;
            } else if (target < arr[mid]) {
                end = mid;
            }else{
                return target;
            }
        }
            return arr[start];
    }
}












