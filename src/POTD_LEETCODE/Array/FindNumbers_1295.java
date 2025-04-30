package POTD_LEETCODE.Array;

class FindNumbers_1295 {
    public int findNumbers(int[] nums) {
        // constraints : num[i] - [1, 10000]
        int count = 0;
        for (int num : nums) {
            if ((num > 9 && num < 100) || (num > 999 && num < 10001) || (num > 99999 && num < 1000000)) {
                count++;
            }
        }
        return count;
    }
}