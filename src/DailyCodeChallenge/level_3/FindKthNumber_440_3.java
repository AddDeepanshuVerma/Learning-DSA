package DailyCodeChallenge.level_3;

class FindKthNumber_440_3 {
    public static void main(String[] args) {
        FindKthNumber_440_3 obj = new FindKthNumber_440_3();
        System.out.println(obj.findKthNumber(13, 10));
    }

    private long ans;
    private long count;

    public int findKthNumber(int n, int k) {
        ans = 0;
        count = 0;
        for (int i = 1; i <= 9; i++) {
            if (solve(i, n, k)) {
                break;
            }
        }
        return (int) ans;
    }

    private boolean solve(long curr, int n, int k) {
        count++;
        if (count == k) {
            ans = curr;
            return true;
        }

        for (int i = 0; i <= 9; i++) {
            long newVal = curr * 10 + i;
            if (newVal > n) break;
            if (solve(newVal, n, k)) return true;
        }
        return false;
    }
}