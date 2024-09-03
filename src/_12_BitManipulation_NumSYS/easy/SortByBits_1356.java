package _12_BitManipulation_NumSYS.easy;

import java.util.Arrays;

class SortByBits_1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted((a,b)-> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b))
                     .mapToInt(n -> n).toArray();
    }
}