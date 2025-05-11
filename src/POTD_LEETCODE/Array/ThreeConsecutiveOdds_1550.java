package POTD_LEETCODE.Array;

class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, k = 3;
        for (int i = 0, j = 0; j < arr.length; j++) {
            count += arr[j] & 1;

            if (j - i + 1 == k) {
                if (count == k) {
                    return true;
                } else {
                    count -= arr[i] & 1;
                    i++;
                }
            }
        }
        return false;
    }
}