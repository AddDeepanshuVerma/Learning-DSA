package POTD_LEETCODE.Array;

class CountSymmetricIntegers_2843 {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int num) {
        int len = (int) Math.log10(num) + 1;
        if ((len & 1) == 1) return false;

        char[] arr = String.valueOf(num).toCharArray();

        int left = 0, right = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            left += arr[i] + '0';
            right += arr[j] + '0';
            i++;
            j--;
        }
        return left == right;
    }
}