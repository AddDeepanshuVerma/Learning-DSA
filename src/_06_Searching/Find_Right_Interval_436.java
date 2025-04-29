package _06_Searching;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.TreeMap;

public class Find_Right_Interval_436 {

    @Description("Using TreeSet : first put arrays first column as key and its row as value in TreeMap " + "then for every value in second column, do a Binary search >= key in that TreeMap and get the value of it.")
    public static int[] findRightInterval2(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];

        TreeMap<Integer, Integer> indexMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < n; i++) {
            res[i] = binarySearchInTreeMap(indexMap, intervals[i][1]);
        }

        return res;
    }

    private static int binarySearchInTreeMap(TreeMap<Integer, Integer> indexMap, int target) {
        if (target > indexMap.lastKey() || target < indexMap.firstKey()) return -1;
        else return indexMap.ceilingEntry(target).getValue();
    }


    private static int binarySearch(int[] arr, int target) {
        int end = arr.length - 1;
        if (target > arr[end] || target < arr[0]) {
            return Integer.MIN_VALUE;
        }
        int start = 0, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return arr[start];
    }

    public static int[] findRightInterval(int[][] arr) {
        int n = arr.length;
        if (n <= 1) return new int[]{-1};
        int[] res = new int[n];
        int[] arrS = new int[n];
        for (int i = 0; i < n; i++) {
            arrS[i] = arr[i][0];
        }
        Arrays.sort(arrS);
        System.out.println(Arrays.toString(arrS));
        for (int i = 0; i < n; i++) {
//            System.out.println("searching to >= "+arr[i][1]);
            int theElement = binarySearch(arrS, arr[i][1]);
//            System.out.println("for "+ i +"th index theElement value :"+ theElement);
            res[i] = theElement != Integer.MIN_VALUE ? binarySearch(arr, theElement) : -1;
            System.out.println("for the Element = " + theElement + " , got res[i] = " + res[i]);
//            System.out.println("for "+ i +"th index array value :"+ res[i]);
        }
        return res;
    }


    private static int binarySearch(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == target) {
                return i;
            }
        }
        return -1;
    }

}
