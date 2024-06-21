package Sorting_07.Ques.Easy;

import java.util.Arrays;

class heightChecker_1051 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(heightChecker(arr));
    }

    public static int heightChecker(int[] heights) {
        int[] res = Arrays.copyOf(heights, heights.length);
        Arrays.sort(res);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (res[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

}