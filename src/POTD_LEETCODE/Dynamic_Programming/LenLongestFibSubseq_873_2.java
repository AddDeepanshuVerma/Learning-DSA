package POTD_LEETCODE.Dynamic_Programming;

class LenLongestFibSubseq_873_2 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 10, 11, 12, 18, 23, 35};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int count = dfs(0, -1, -1, arr.length, arr);
        return count > 2 ? count : 0;
    }

    private static int dfs(int i, int pp, int p, int n, int[] arr) {
        if (i >= n) {
            return 0;
        }

        int count = 0;
        if (pp == -1 || p == -1) {
            for (int j = i; j < n; j++) {
                if (pp == -1) {
                    count = Math.max(count, 1 + dfs(j + 1, arr[j], p, n, arr));
                } else {
                    count = Math.max(count, 1 + dfs(j + 1, pp, arr[j], n, arr));
                }
            }
        } else {
            for (int j = i; j < n; j++) {
                if (arr[j] == pp + p) {
                    count = Math.max(count, 1 + dfs(j + 1, p, arr[j], n, arr));
                }
            }
        }

        return count;
    }
}