package BinarySearch;

public class Searching {

    public static void main(String[] args) {

        /*char[] letters = {'x','x','x','y','y'};
        System.out.println(nextGreatestLetter(letters , 'x'));*/

        int[] mountainArr = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(findInMountainArray(target,mountainArr));
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
       /*  1. find the peak index of the array.
           2. If Peak index in greater than target then find target element in first Array or-else return -1
           3. if not found in first half , try in second half*/
        int peak  = peakIndexInMountainArray(mountainArr);
        if(target <= mountainArr[peak]){
            int index = orderAgnosticBS(mountainArr , target , 0, peak);
            if(index == -1){
                return orderAgnosticBS(mountainArr , target , peak , mountainArr.length-1);
            }
            return index;
        }
        else return -1;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                // We are in the decreasing part of the array
                // Here mid can be a potential answer
                end  = mid;
            }
            if(arr[mid] < arr[mid+1]){
                // We are in the increasing part of the array
                // Here mid can not be a potential answer
                start = mid + 1;
            }
        }
        // while-loop condition gets false when start was equal to end which is equal to our answer
        return start;
    }

    public static int orderAgnosticBS(int[] arr, int target, int start, int end) {
//        int start = 0;
//        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end){

            int mid  = start + (end - start)/2;
            if(target < letters[mid]){
                end =  mid -1;
            }else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}


