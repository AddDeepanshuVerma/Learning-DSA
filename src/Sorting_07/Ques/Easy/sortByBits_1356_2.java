package Sorting_07.Ques.Easy;

import jdk.jfr.Description;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class sortByBits_1356_2 {
    public static void main(String[] args) {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    private static int[] sortByBits2(int[] arr) {
        Integer[] wrapper = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(wrapper, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b));
        return Arrays.stream(wrapper).mapToInt(Integer::intValue).toArray();
    }


    public static int[] sortByBits(int[] arr) {
        Integer[] wrappedArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            wrappedArray[i] = arr[i];
        }
        Comparator<Integer> comp = (a, b) -> {
            return Integer.bitCount(a) == Integer.bitCount(b)
                    ? a - b
                    : Integer.bitCount(a) - Integer.bitCount(b);
        };
        Arrays.sort(wrappedArray, comp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = wrappedArray[i];
        }
        return arr;
    }
}