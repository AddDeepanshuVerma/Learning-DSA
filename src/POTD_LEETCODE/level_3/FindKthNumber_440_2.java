package POTD_LEETCODE.level_3;

class FindKthNumber_440_2 {
    public static void main(String[] args) {
        FindKthNumber_440_2 obj = new FindKthNumber_440_2();
        System.out.println(obj.findKthNumber(13, 10));
    }

    int ans;
    int count;

    // would not 90% was correct, Well done tho
    // check _3 for correct way for below approach
    public int findKthNumber(int n, int k) {
        count = k - 1;
        ans = -1;
        for (int i = 1; i <= 9; i++) {
            if (solve(i, n)) {
                break;
            }
        }
        return ans;
    }

    private boolean solve(int curr, int n) {
        if (count == 0) {
            ans = curr;
            return true;
        }

        for (int i = 0; i <= 9; i++) {
            int newVal = curr * 10 + i;
            if (newVal > n) break;
            count--;
            if (solve(newVal, n)) return true;
        }
        return false;
    }
}