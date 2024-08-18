package DailyCodeChallenge.Level_2;

class MaxPoints_1937 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1},};
        int[][] arr2 = {{1, 5}, {2, 3}, {4, 2},};
        MaxPoints_1937 obj = new MaxPoints_1937();
        System.out.println("maxPoints : " + obj.maxPoints(arr));
    }

    public long maxPoints(int[][] points) {
        int row = 0, col = 0;
        return solve(points, row, col);
    }

    private long solve(int[][] arr, int row, int col) {
        if (row >= arr.length) return 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[row].length; i++) {
            long sum = arr[row][i] + solve(arr, row + 1, i) - ((row > 0) ? Math.abs(col - i) : 0);
            max = Math.max(max, sum);
        }
        return max;
    }

}