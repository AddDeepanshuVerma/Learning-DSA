package DailyCodeChallenge.Array;

import java.util.Arrays;

class Decrypt_1652 {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int[] res = decrypt(code, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;

        /* if k == 0; return an n size array with all zeroes in it. */
        if (k == 0) return new int[n];

        int[] res = new int[n];
        int[] prefix = getPrefix(code, k);
        if (k < 0) {
            k *= -1;
            int totalSum = prefix[n - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = (k / n * totalSum) + prefix[n + i - 1] - prefix[n + i - 1 - k];
            }
        } else {
            int totalSum = prefix[n];
            for (int i = 0; i < res.length; i++) {
                res[i] = (k / n * totalSum) + prefix[i + 1] - prefix[i + 1 + k];
            }
        }
        return res;
    }

    private static int[] getPrefix(int[] code, int k) {
        int base = code.length;
        int[] res = new int[2 * base];
        int n = res.length;

        if (k < 0) { // prefix
            res[0] = code[0];
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] + code[i % base];
            }
        } else { // postfix
            res[n - 1] = code[base - 1];
            for (int i = res.length - 2; i >= 0; i--) {
                res[i] = res[i + 1] + code[i % base];
            }
        }
        return res;
    }
}