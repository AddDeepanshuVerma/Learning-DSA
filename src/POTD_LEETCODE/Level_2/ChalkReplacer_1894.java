package POTD_LEETCODE.Level_2;

class ChalkReplacer_1894 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2};
        ChalkReplacer_1894 obj = new ChalkReplacer_1894();
        System.out.println(obj.chalkReplacer2(arr, 25));
    }

    public int chalkReplacer(int[] chalk, long k) {
        long sum = 0;
        for (int i : chalk) sum += i;

        if (k % sum == 0) return 0;
        if (k > sum) k = k % sum;

        for (int i = 0; i < chalk.length; i++) {
            if (k - chalk[i] >= 0) {
                k -= chalk[i];
            } else {
                return i;
            }
        }
        return -1;
    }

    public int chalkReplacer2(int[] chalk, long k) {
        long sum = 0;
        for (int i : chalk) sum += i;
        k = k % sum;
        int i = 0;
        while (k >= 0) {
            k -= chalk[i++];
        }
        return i-2;
    }
}