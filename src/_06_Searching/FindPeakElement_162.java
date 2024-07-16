package _06_Searching;

public class FindPeakElement_162 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,4,5}));
    }

    public static int findPeakElement(int[] arr) {
        if (arr.length == 2) return Math.max(arr[0], arr[1]);
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            if(arr[mid] > arr[mid - 1])
                start = mid + 1;
            else end = mid - 1;
        }
        return arr[start];
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
