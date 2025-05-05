package POTD_LEETCODE.Recursion;

// Does not work as == & != statement repeats the same pattern again in case of == && ==
class NumTilings_790 {
    public static int numTilings(int n) {
        int x = 0, y = 0;
        return dfs(x, y, n);
    }

    private static int dfs(int x, int y, int n) {
        if (x > n || y > n) return 0;
        if (x == n && y == n) return 1;

        int count = 0;

        if (x == y) count += dfs(x + 1, y + 1, n);         // add |
        if (x != y) count += dfs(x + 2, y, n);               // add -
        if (x != y) count += dfs(x, y + 2, n);               // add _
        if (x == y) count += dfs(x + 2, y + 2, n);        // add =
        if (x == y) count += dfs(x + 1, y + 2, n);       // add L
        if (x == y) count += dfs(x + 2, y + 1, n);       // add |-
        if (y - x == 1) count += dfs(x + 2, y + 1, n);  // add -|
        if (x - y == 1) count += dfs(x + 1, y + 2, n);  // add _|

        return count;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int ans = numTilings(i);
            System.out.println("for " + i + " == "  + ans);
        }

    }
}