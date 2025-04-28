package POTD_LEETCODE.Dynamic_Programming;

class LenLongestFibSubseq_873 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }

    private static int ans;

    public static int lenLongestFibSubseq(int[] arr) {
        ans = 0;
        dfs(0, -1, -1, 0, arr.length, arr);
        return ans > 2 ? ans : 0;
    }

    private static void dfs(int i, int pp, int p, int count, int n, int[] arr) {
        ans = Math.max(ans, count);
        if (i >= n) {
            return;
        }

        if (pp == -1 || p == -1) {
            for (int j = i; j < n; j++) {
                if (pp == -1) {
                    dfs(j + 1, arr[j], p, count + 1, n, arr);
                } else {
                    dfs(j + 1, pp, arr[j], count + 1, n, arr);
                }
            }
        } else {
            for (int j = i; j < n; j++) {
                if (arr[j] == pp + p) {
                    dfs(j + 1, p, arr[j], count + 1, n, arr);
                }
            }
        }
    }
}