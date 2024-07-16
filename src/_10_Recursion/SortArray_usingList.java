package _10_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray_usingList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 1, 4, 5, 6, 7));
        sort(list);
        System.out.println(list);
    }

    public static void sort(List<Integer> arr) {
        if (arr.size() == 1) return;
        int temp = arr.remove(arr.size() - 1);
        sort(arr);
        insert(arr, temp);
    }

    public static void insert(List<Integer> arr, int temp) {
        if (arr.isEmpty() || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);return;
        }
        int value = arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(value);
    }
}
