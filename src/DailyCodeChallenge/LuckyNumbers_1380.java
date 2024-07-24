package DailyCodeChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LuckyNumbers_1380 {
    public static void main(String[] args) {
        int[][] arr = {{56216}, {63251}, {75772}, {1945}, {27014}};
        System.out.println(new LuckyNumbers_1380().luckyNumbers(arr));
    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int rMinMax = Integer.MIN_VALUE;

        for (int row = 0; row < m; row++) {
            int rMin = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }
            rMinMax = Math.max(rMinMax, rMin);
        }

        int cMaxMin = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            int cMax = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }
            cMaxMin = Math.min(cMaxMin, cMax);
        }

        List<Integer> result = new ArrayList<>();
        if (rMinMax == cMaxMin) {
            result.add(rMinMax); // {cMaxMin}
        }

        return result;
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            int rMin = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }
            rowMin.add(rMin);
        }

        List<Integer> colMax = new ArrayList<>();
        for (int col = 0; col < n; col++) {
            int cMax = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }
            colMax.add(cMax);
        }

        List<Integer> result = new ArrayList<>();
        here:
        for (Integer integer : rowMin)
            for (Integer max : colMax)
                if (integer.equals(max)) {
                    result.add(integer);
                    break here;
                }
        return result;
    }
}