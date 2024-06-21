package Sorting_07.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

class arrayRankTransform_1331 {
    public static void main(String[] args) {
        int[] arr = {37, 12, 28, 9, 100, 100, 100, 56, 80, 5, 12};
        int[] arr2 = {5, 3, 4, 2, 8, 6, 7, 1, 3};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] arrayRankTransform(int[] arr) {
//        int[] comp = Arrays.copyOf(arr, arr.length);
        int[] comp = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(comp);
        for (int i = 0, j = 1; i < comp.length; i++) {
            if (!map.containsKey(comp[i])) {
                map.put(comp[i], j++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        System.out.println(map);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] arrayRankTransform2(int[] arr) {
        TreeSet<Integer> TS = new TreeSet<>();
        for (int i : arr) TS.add(i);
        int[] array = TS.stream().mapToInt(x -> x).toArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = binarySearchFirstIndex(array, arr[i]);
        }
        return arr;
    }

    private static int binarySearchFirstIndex(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid = 0;
        int index = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] == target) {
                index = mid;
                end = mid - 1;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index + 1;
    }
}