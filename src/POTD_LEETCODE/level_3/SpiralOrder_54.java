package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder_54 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralOrder_54 obj = new SpiralOrder_54();
        System.out.println(obj.spiralOrder(arr2));
    }

    public List<Integer> spiralOrder(int[][] arr2D) {
        int row = arr2D.length;
        int col = arr2D[0].length;
        List<Integer> list = new ArrayList<>();

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
        return list;
    }
}