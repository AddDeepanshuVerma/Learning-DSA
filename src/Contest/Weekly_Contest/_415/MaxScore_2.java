package Contest.Weekly_Contest._415;

// Does not work
class MaxScore_2 {
    public static void main(String[] args) {
        int[] a = {-1, 4, 5, -2};
        int[] b = {-5, -1, -3, -2, -4};
        MaxScore_2 obj = new MaxScore_2();
        System.out.println(obj.maxScore(a, b));

        int[] a1 = {3, 2, 5, 6};
        int[] b1 = {2, -6, 4, -5, -3, 2, -7};
        System.out.println(obj.maxScore(a1, b1));
    }

    long globalSum;

    public long maxScore(int[] a, int[] b) {
        globalSum = Integer.MIN_VALUE;
        solve(a, b, 0, 0);
        return globalSum;
    }

    private void solve(int[] a, int[] b, int index, long sum) {
        if (index >= 4) {
            globalSum = Math.max(globalSum, sum);
            return;
        }

        for (int i = index; i <= b.length - (4 - index); i++) {
            long temp = (long) a[index] * b[i];
            solve(a, b, i + 1, sum + temp);
        }
    }
}