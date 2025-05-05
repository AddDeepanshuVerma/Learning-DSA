package POTD_LEETCODE.Recursion;

// Works fine as repeated statements has been removed :: Recursion === TLE
class NumTilings_790_2 {
    public static int numTilings(int n) {
        int firstRow = 0, secondRow = 0;
        return dfs(firstRow, secondRow, n);
    }

    private static int dfs(int x, int y, int n) {
        if (x > n || y > n) return 0;
        if (x == n && y == n) return 1;

        int count = 0;

        if (x == y) {
            count += dfs(x + 1, y + 1, n);       // add |
            count += dfs(x + 2, y + 2, n);       // add =
            count += dfs(x + 1, y + 2, n);       // add L
            count += dfs(x + 2, y + 1, n);       // add |-
        } else if (x < y) {
            count += dfs(x + 2, y, n);              // add -
            count += dfs(x + 2, y + 1, n);       // add _|
        } else {
            count += dfs(x, y + 2, n);              // add _
            count += dfs(x + 1, y + 2, n);       // add _|
        }

        return count;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int ans = numTilings(i);
            System.out.println("for " + i + " == " + ans);
        }
    }
}