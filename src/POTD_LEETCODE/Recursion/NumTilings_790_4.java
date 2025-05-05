package POTD_LEETCODE.Recursion;

// Works fine as repeated statements has been removed :: Recursion + Readability === TLE
class NumTilings_790_4 {
    public static int numTilings(int n) {
        int x = 0, y = 0;
        return dfs(n, n);
    }

    private static int dfs(int firstRow, int SecondRow) {
        if (firstRow == 0 && SecondRow == 0) return 1;
        if (firstRow < 0 || SecondRow < 0) return 0;

        int count = 0;
        if (firstRow == SecondRow) {
            count += dfs(firstRow - 1, SecondRow - 1);       // add |
            count += dfs(firstRow - 2, SecondRow - 2);       // add =
            count += dfs(firstRow - 1, SecondRow - 2);       // add L
            count += dfs(firstRow - 2, SecondRow - 1);       // add |-
        } else if (firstRow > SecondRow) {
            count += dfs(firstRow - 2, SecondRow);                      // add -
            count += dfs(firstRow - 2, SecondRow - 1);        // add _|
        } else {
            count += dfs(firstRow, SecondRow - 2);                   // add _
            count += dfs(firstRow - 1, SecondRow - 2);       // add _|
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