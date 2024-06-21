package Sorting_07.Ques.Easy;

import java.util.Arrays;

class canMakeArithmeticProgression_1502 {
    public static void main(String[] args) {

    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] - arr[i+1] != diff) {
                return false;
            }
        }
        return true;
    }
}