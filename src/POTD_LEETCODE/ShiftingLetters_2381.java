package POTD_LEETCODE;

import java.util.Arrays;

class ShiftingLetters_2381 {
    public static void main(String[] args) {
        String s = "abz";
        int[][] shifts = {{0, 1, 0}, {1, 2, 0}, {0, 2, 0}};
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length()];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2] == 1 ? 1 : -1;
            for (int i = start; i <= end; i++) {
                diff[i] += dir;
            }
        }
        System.out.println("diff = " + Arrays.toString(diff));

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int ch = arr[i] - 'a';
            ch += diff[i];
            arr[i] = (char) ((((ch % 26) + 26) % 26) + 'a');
        }

        return String.valueOf(arr);
    }

}