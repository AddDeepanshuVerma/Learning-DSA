package Random;

import java.util.*;

public class Searching {
    static int[] arr = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};
    static int[] sortedArr = new int[]{2};
    static int[] sortedArr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static int[][] arr2D = new int[][]{
            {2, 3, 1, 4, 5},
            {7, 4, 8, 1, 9},
            {9, 2, 6, 1, 8}
    };
    public static void main(String[] args) {
//        searchWithTimeLapsed();
//        System.out.println("Index = " + binarySearch(sortedArr, 3));
//        System.out.println(searchInsert(sortedArr ,  2));
//        System.out.println(nextGreatestLetter2(new char[]{'c', 'f' , 'j'} , 'c'));
//        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j' }, 'c'));
//        System.out.println(mySqrt(2147483647));
//        System.out.println(arrangeCoins(9));
//        System.out.println(findKthPositive3(sortedArr, 1));
//        System.out.println(findKthPositive(sortedArr, 1));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1},
//                new int[]{2, 2})));
//        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,1} , new int[]{2,2} )));
//        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,2} , new int[]{2,3} )));
//        System.out.println(Arrays.toString(fairCandySwap(new int[]{35,17,4,24,10} , new int[]{63,21} )));
        //[24,21]
//        System.out.println(binarySearch( new int[]{63,21} , 21));

        System.out.println(checkIfExist(new int[]{-10,12,-20,-8,15}));
//        System.out.println(binarySearch(new int[]{2,3,5,10} ,2, 10));
        Map<String, Integer> maper = new HashMap<>();

    }


    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i= 0; i< arr.length ; i++){
            if(arr[i] == 0 ) return true;
            int target = 2 * arr[i];
            if( target <= arr[arr.length -1 ] && binarySearching(arr, target))
                return true;
        }
        return false;
    }

    static boolean binarySearching(int[] arr, int target){
        int start = 0, end = arr.length - 1, mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(target == arr[mid]) return true;
            else if(target < arr[mid]) end = mid -1;
            else start = mid + 1;
        }
        return false;
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0, sumBob = 0;
        for (int k : aliceSizes) {
            sumAlice += k;
        }
        for (int l : bobSizes) {
            sumBob += l;
        }
        int median = Math.abs((sumBob + sumAlice)/2);
        int remainingSumAlice = 0,requirementToMeetMedian = 0;
        for (int aliceGivenCandy : aliceSizes) {
            remainingSumAlice = (sumAlice - aliceGivenCandy);
            requirementToMeetMedian = median - remainingSumAlice;
            if (requirementToMeetMedian < 0) continue;
            Arrays.sort(bobSizes);
            if(binarySearch(bobSizes, requirementToMeetMedian)){
                return new int[]{aliceGivenCandy, requirementToMeetMedian};
            }
        }
        return new int[]{-1,-1};
    }

    private static boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start)/2;
            if(target  == arr[mid]) return true;
            else if(target < arr[mid]) end = mid -1 ;
            else start = mid + 1;
        }
        return false;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //sort both array
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length - 1;
        int m = nums2.length - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i <= n && j <= m; ) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int count  = 0;
        for (int k : nums1)  arr[k] = 1;
        for (int k : nums2) if (arr[k] >= 1) arr[k] = 2;
        for (int k : arr)  if (k > 1) count++;
        int[] res = new int[count];
        for(int i = 0, j = 0; i<arr.length; i++){
            if(arr[i] > 1){
                res[j] = i;
                j++;
            }
        }
        return res;
    }
    public static int findKthPositive(int[] arr, int k) {
        int start = 0, end  = arr.length-1, mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] - mid-1 >= k)
                end  = mid-1;
            else
                start = mid+1;
        }
        System.out.println(start + " "+ end);
//        return start + k;
        int elementLied = arr[end] -(start);
        return arr[end] + (k - elementLied);
    }

    public static int findKthPositive3(int[] arr, int k) {
        int start = 0, end  = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] - mid-1 >= k)
                end  = mid -1;
            else
                start = mid+1;
        }
        return start + k;
    }
    public int findKthPositive2(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        // Find the first index starts.t. nMissing(l) = A[l] - start- 1 >= k.
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] - mid - 1 >= k)
                end = mid;
            else
                start = mid + 1;
        }
        return start + k;
    }
    public static int arrangeCoins(int n) {

        return (int) (Math.sqrt(n * 8L + 1) - 1 ) / 2;
        /*long start = 1, end = n, mid = 0;
        while(start <=  end ){
            mid = start + (end-start)/2;
            long value = mid*(mid+1);
            if(value == 2L*n) return (int)mid;
            if(value > 2L*n) end = mid -1;
            else start = mid +1;
        }
        return (int)end;*/
    }

    public static int mySqrt(int x) {
        if(x == 0 || x  == 1 ) return x;
        long start = 0, end  = x/2, mid = 0;
        while(start <= end ){
            mid = start + (end - start)/2;
            if(mid * mid == x)
                return (int)mid;
            if(mid * mid > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return (int)end;
    }

    static void searchWithTimeLapsed(){
        long start2 = System.currentTimeMillis();
        long start1 = System.nanoTime();
        // write the code to measure :===>
        /*int x = 2147483647 , count  = 0;
        for (int i = 0; i < 100; i++, x = x/2, count++) {

            int result = mySqrt(x);
            System.out.println(result);
            if(result == 0) {
                System.out.println("count : "+ count);
                break;
            }
        }*/
        long end1 = System.nanoTime();
        long end2 = System.currentTimeMillis();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
        System.out.println("Elapsed Time in milli seconds: " + (end2 - start2));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        /*if(nums.length == 0 ){
            return res;
        }*/
        //Find first occurenece
        res[0] = occurance(nums, target, true);
        //Find second occurenece only if first was found
        res[1] = res[0]!= -1 ? occurance(nums, target, false) : -1;
        return res;
    }
    static int occurance( int[] nums , int target , boolean first){
        int start = 0 ;
        int end  = nums.length - 1;
        boolean foundTheElement = false;
        while(start <= end ){
            int mid = start + (end  - start)/2;
            if(target  ==  nums[mid]){
                foundTheElement = true;
                if(first) end = --mid;
                else start = ++mid;
            }else if(target < nums[mid])
                end = --mid;
            else  start = ++mid;
        }
        return foundTheElement? first ? start : end : -1;
    }
    static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1 ;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            /*if (target == arr[mid]) {
                res = mid; break;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }*/
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start + " " + end);
        return arr[start%arr.length];
    }
    static int binarySearch(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid+1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start + " " + end);
        return -1;
    }
    public static char nextGreatestLetter2(char[] letters, char target) {
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
        System.out.println("start : " + start + ", end :" + end);
        return letters[start % letters.length];
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end  = nums.length-1;
        while(start <= end){
            int mid  = start +(end-start)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}
