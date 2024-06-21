package Sorting_07.Algos;


import java.util.*;

class FindDuplicates_442 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,2,2,2,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[correct] == arr[i]) {
                i++;
            } else {
                swap(arr, correct, i);
            }
        }
        System.out.println(Arrays.toString(arr));
//         got the sorted array
//         now find the missing numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                set.add(arr[i]);
            }
        }
        return new ArrayList<>(set);
    }

    static void swap(int[] arr, int first, int end) {
        int temp = arr[first];
        arr[first] = arr[end];
        arr[end] = temp;
    }
}