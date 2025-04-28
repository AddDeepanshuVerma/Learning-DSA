package POTD_LEETCODE.BackTracking;

class SmallestNumber_2375 {
    public static void main(String[] args) {
        var obj = new SmallestNumber_2375();
        System.out.println(obj.smallestNumber("IIIDIDDD"));
        System.out.println(obj.smallestNumber("DDD"));
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder ans = new StringBuilder();
        boolean[] seen = new boolean[10];

        int min = 1, max = 9;
        solve(0, pattern, ans, seen, pattern.length(), min, max);
        return ans.toString();
    }

    private boolean solve(int idx, String pattern, StringBuilder ans, boolean[] seen, int n, int min, int max) {
        if (ans.length() == n + 1) {
            return true;
        }

        for (int i = min; i <= max; i++) {
            if (seen[i]) {
                continue;
            }

            seen[i] = true;
            ans.append(i);

            int newMin, newMax;
            if (idx < n && pattern.charAt(idx) == 'I') {
                newMin = i + 1;
                newMax = 9;
            } else {
                newMin = 1;
                newMax = i - 1;
            }
            if (solve(idx + 1, pattern, ans, seen, n, newMin, newMax)) {
                return true;
            }

            seen[i] = false;
            ans.deleteCharAt(ans.length() - 1);
        }
        return false;
    }
}