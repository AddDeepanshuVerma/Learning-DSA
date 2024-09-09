package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr2D = {
                {1,2,3,4,5,6,7,8},
                {20,21,22,23,24,25,26,9},
                {19,32,31,30,29,28,27,10},
                {18,17,16,15,14,13,12,11}
        };
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SpiralMatrix(arr2D, 4, 8);
        System.out.println("list = " + list);
    }

    private static void SpiralMatrix(int[][] arr2D, int row, int col) {
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (true) {
            for (int i = left; i <= right; i++) list.add(arr2D[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) list.add(arr2D[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) list.add(arr2D[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) list.add(arr2D[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }
    }
}
