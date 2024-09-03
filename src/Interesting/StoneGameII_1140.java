package Interesting;

class StoneGameII_1140 {
    public int stoneGameII(int[] piles) {
        boolean alice = true;
        int index = 0;
        int M = 1;
        return solve(piles, alice, index, M);
    }

    private int solve(int[] arr, boolean alice, int index, int M) {
        int n = arr.length;
        if (index >= n) return 0;
        int result = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= Math.min(2 * M, n - index); i++) {
            sum += arr[i + index - 1];
            int temp;
            if (alice) {
                temp = sum + solve(arr, false, i + index, Math.max(M, i));
                result = Math.max(result, temp);
            } else {
                temp = solve(arr, true, i + index, Math.max(M, i));
                result = Math.min(result, temp);
            }
        }
        return result;
    }
}