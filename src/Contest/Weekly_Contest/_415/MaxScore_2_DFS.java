package Contest.Weekly_Contest._415;

// Does work
class MaxScore_2_DFS {
    public static void main(String[] args) {
        int[] a = {-1, 4, 5, -2};
        int[] b = {-5, -1, -3, -2, -4};
        MaxScore_2_DFS obj = new MaxScore_2_DFS();
        System.out.println(obj.maxScore(a, b));

        int[] a1 = {3, 2, 5, 6};
        int[] b1 = {2, -6, 4, -5, -3, 2, -7};
//        System.out.println(obj.maxScore(a1, b1));
    }

    long globalSum;

    public long maxScore(int[] a, int[] b) {
        globalSum = Integer.MIN_VALUE;
        solve(a, b, 0, 0, 0);
        return globalSum;
    }

    private void solve(int[] a, int[] b, int index, int count, int sum) {
        if (count >= 4) {
            globalSum = Math.max(globalSum, sum);
            return;
        }
        // If we have exhausted the list or can't pick 4 indices anymore
        if (index >= b.length || count + (b.length - index) < 4) {
            return;
        }

        solve(a, b, index + 1, count + 1, sum + a[count] * b[index]);
        solve(a, b, index + 1, count, sum);
    }

    private void solve2(int[] a, int[] b, int index, int count, int sum) {
        if (count >= 4) {
            globalSum = Math.max(globalSum, sum);
            return;
        }

        if (index < b.length && count + (b.length - index) >= 4) {
            solve(a, b, index + 1, count + 1, sum + a[count] * b[index]);
            solve(a, b, index + 1, count, sum);
        }
    }
}