package POTD_LEETCODE.Array;

class MaxScore_1422 {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore2(s));
    }

    // TC:O(2N) & SC:O(N)
    public static int maxScore(String s) {
        char[] arr = s.toCharArray();
        int[] temp = new int[arr.length];

        int sum = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            sum += arr[i] - '0';
            temp[i] = sum;
        }

        int count = Integer.MIN_VALUE;
        int zeros = (arr[0] - '0') ^ 1;
        for (int i = 1; i < temp.length; i++) {
            count = Math.max(count, zeros + temp[i]);
            zeros += (arr[i] - '0') ^ 1;
        }
        return count;
    }

    // TC:O(2N) & SC:O(1)
    public static int maxScore2(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            sum += ch - '0';
        }

        int count = Integer.MIN_VALUE;
        int currSum = arr[0] - '0';
        for (int i = 1; i < arr.length; i++) {
            int rightOnes = sum - currSum;
            int leftZeros = i - currSum;

            count = Math.max(count, rightOnes + leftZeros);
            currSum += arr[i] - '0';
        }
        return count;
    }

    // TC:O(N) & SC:1 (BEST O(N) approach)
    public int maxScore3(String s) {
        int ones = 0, zeros = 0;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }

            best = Math.max(best, zeros - ones);
        }

        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }

        return best + ones;
    }
}