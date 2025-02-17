package POTD_LEETCODE.Array;

import java.util.Arrays;

class MaxChunksToSorted_769 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int sum1 = 0, sum2 = 0, chunk = 0;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            sum1 += temp[i];
            sum2 += arr[i];
            if (sum1 == sum2)
                chunk++;
        }
        return chunk;
    }
}