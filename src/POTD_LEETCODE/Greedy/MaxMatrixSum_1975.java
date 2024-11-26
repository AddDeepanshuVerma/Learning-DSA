package POTD_LEETCODE.Greedy;

class MaxMatrixSum_1975 {
    public long maxMatrixSum(int[][] matrix) {
        long xor = 0;
        long sum = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val;
                if (matrix[i][j] < 0) {
                    xor ^= 1;
                    val = Math.abs(matrix[i][j]);
                } else val = matrix[i][j];

                min = Math.min(min, val);
                sum += val;
            }
        }
        return sum - xor * (min << 1);
    }

}