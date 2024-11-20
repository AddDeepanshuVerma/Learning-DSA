package POTD_LEETCODE.Level_2;

class MaxPoints_1937_2 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1},};
        int[][] arr2 = {{1, 5}, {2, 3}, {4, 2},};
        MaxPoints_1937_2 obj = new MaxPoints_1937_2();
        System.out.println("maxPoints : " + obj.maxPoints(arr));
    }

    long[][] dp;

    public long maxPoints(int[][] points) {
        dp = new long[10001][10001];
        int row = 0, col = 0;
        return solve(points, row, col);
    }

    private long solve(int[][] arr, int row, int col) {
        if (row >= arr.length) return 0;
        long max = Integer.MIN_VALUE;
        if (row == 0) {
            for (int i = 0; i < arr[row].length; i++) {
                long sum = arr[row][i] + solve(arr, row + 1, i);
                max = Math.max(max, sum);
            }
        }else {
            for (int i = 0; i < arr[row].length; i++) {
                long sum = arr[row][i] + solve(arr, row + 1, i) - Math.abs(col - i);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}