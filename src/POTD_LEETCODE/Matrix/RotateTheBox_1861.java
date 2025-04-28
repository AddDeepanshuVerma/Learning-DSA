package POTD_LEETCODE.Matrix;

import java.util.Arrays;

class RotateTheBox_1861 {
    public static void main(String[] args) {
        char[][] box = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] res = rotateTheBox(box);
        for (char[] re : res) System.out.println(Arrays.toString(re));
    }

    public static char[][] rotateTheBox(char[][] box) {
//        stone '#' obstacle '*' Empty '.'
        int row = box.length;
        int col = box[0].length;

        char[][] result = new char[col][row];

        for (int i = 0; i < box.length; i++) {
            char[] temp = getVerticalArray(box[i]);
            putArrayToColumn(result, temp, row - i - 1);
        }

        return result;
    }

    private static char[] getVerticalArray(char[] box) {
        int n = box.length;
        char[] temp = new char[n];
        int stone = 0, empty = 0;
        int k = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (box[i] == '#') stone++;
            else if (box[i] == '.') empty++;
            else { // not its obstacle
                putStoneAndEmpty(stone, empty, k, temp);
                k -= (stone + empty);
                stone = 0;
                empty = 0;
                temp[k--] = '*';
            }
        }
        if (k >= 0) {
            putStoneAndEmpty(stone, empty, k, temp);
        }
        return temp;
    }

    private static void putStoneAndEmpty(int stone, int empty, int index, char[] temp) {
        while (stone-- != 0) temp[index--] = '#';
        while (empty-- != 0) temp[index--] = '.';
    }

    private static void putArrayToColumn(char[][] result, char[] temp, int col) {
        for (int i = 0; i < temp.length; i++) {
            result[i][col] = temp[i];
        }
    }
}