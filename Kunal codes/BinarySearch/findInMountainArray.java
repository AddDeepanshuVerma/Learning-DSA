package BinarySearch;

public class findInMountainArray implements MountainArray{
    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }


    public static int findInMountainArray(int target, MountainArray mountainArr) {
       /*  1. find the peak index of the array.
           2. If Peak index in greater than target then find target element in first Array or-else return -1
           3. if not found in first half , try in second half*/
        int peak  = peakIndexInMountainArray(mountainArr);
        if(target <= mountainArr.get(peak)){
            int index = orderAgnosticBS(mountainArr , target , 0, peak);
            if(index == -1){
                return orderAgnosticBS(mountainArr , target , peak , mountainArr.length());
            }
            return index;
        }
        else return -1;
    }

    public static int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length()-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr.get(mid) > arr.get(mid+1)){
                // We are in the decreasing part of the array
                // Here mid can be a potential answer
                end  = mid;
            }
            if(arr.get(mid) < arr.get(mid+1)){
                // We are in the increasing part of the array
                // Here mid can not be a potential answer
                start = mid + 1;
            }
        }
        // while-loop condition gets false when start was equal to end which is equal to our answer
        return start;
    }

    public static int orderAgnosticBS(MountainArray arr, int target, int start, int end) {
//        int start = 0;
//        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr.get(start) < arr.get(end);

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}


