package Contest.Weekly_Contest._449;

public class Q2 {

    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        int m = grid.length, n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }
        if ((totalSum & 1) == 1) return false; // odd sum
        totalSum >>= 1;

        // fill Row sums
        for (int r = 0; r < m; r++) {
            int temp = 0;
            for (int c = 0; c < n; c++) {
                temp += grid[r][c];
            }
            rowSum[r] = temp;
        }
        // now fill column sum
        for (int c = 0; c < n; c++) {
            int temp = 0;
            for (int r = 0; r < m; r++) {
                temp += grid[r][c];
            }
            colSum[c] = temp;
        }

        return partitionPossible(totalSum, rowSum) || partitionPossible(totalSum, colSum);
    }

    private boolean partitionPossible(long sum, int[] arr) {
        long temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            temp += arr[i];
            if (temp == sum) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        int[][] grid = {{1, 4, 1}, {2, 3, 5}, {4, 4, 12}};
        boolean ans = obj.canPartitionGrid(grid);
        System.out.println("ans = " + ans);
    }
}
