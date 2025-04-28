package POTD_LEETCODE.Recursion;

class NumberOfPowerfulInt_2999 {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        if (Long.parseLong(s) > finish) return 0;

        int n = String.valueOf(finish).length() - s.length();
        String curr = "_".repeat(n) + s;
        return dfs(n - 1, curr.toCharArray(), limit, start, finish);
    }

    private long dfs(int i, char[] arr, int limit, long start, long finish) {
        if (i < 0) {
            long val = Long.parseLong(String.valueOf(arr));
            return (val >= start && val <= finish) ? 1 : 0;
        }

        long count = 0;
        for (int j = 0; j <= limit; j++) {
            arr[i] = (char) (j + '0');
            count += dfs(i - 1, arr, limit, start, finish);
            arr[i] = '_';
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new NumberOfPowerfulInt_2999();
        long start = 20, finish = 1159;
        int limit = 5;
        String s = "20";
        long ans = obj.numberOfPowerfulInt(start, finish, limit, s);
        System.out.println(ans);
    }
}