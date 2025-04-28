package Interesting;

import java.util.Arrays;
import java.util.HashSet;

class CountGoodIntegers_3272 {
    private long kPalindromes = 0;
    private static HashSet<Long> processed ;
    private final static long[] fact = new long[11];

    static {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < fact.length; ++i)
            fact[i] = i * fact[i - 1];
    }

    public static void main(String[] args) {
        var obj = new CountGoodIntegers_3272();
        long count = obj.countGoodIntegers(3, 5);
        System.out.println("l = " + count);
    }

    public long countGoodIntegers(int n, int k) {
        processed = new HashSet<>();
        char[] number = new char[n];
        generatePalindromes(0, n, number, k);
        return kPalindromes;
    }

    private void generatePalindromes(int pos, int n, char[] number, int k) {
        if (pos >= (n + 1) / 2) {
            if (isKPalindrome(number, n, k)) {
                kPalindromes += allArrangements(String.valueOf(number), n);
            }
            return;
        }

        char ch = (pos == 0) ? '1' : '0';
        while (ch <= '9') {
            number[pos] = ch;
            number[n - pos - 1] = ch;
            generatePalindromes(pos + 1, n, number, k);
            ch++;
        }
        //number[pos] = ' '; // no need to backTrack
    }

    private boolean isKPalindrome(char[] number, int n, int k) {
        return Long.parseLong(String.valueOf(number)) % k == 0;
    }

    private long allArrangements(String str, int n) {
        char[] number = str.toCharArray();
        Arrays.sort(number);
        long num = Long.parseLong(String.valueOf(number));
        if (processed.contains(num)) return 0;

        processed.add(num);
        int[] freq = new int[10];
        for (char c : number)
            freq[c - '0']++;

        long totalPermutations = countAllPermutations(freq, n);
        long invalidPermutations = 0;
        if (freq[0] > 0) {
            freq[0]--;
            invalidPermutations = countAllPermutations(freq, n - 1);
        }
        return totalPermutations - invalidPermutations;
    }

    private long countAllPermutations(int[] freq, int n) {
        long count = fact[n];
        for (int i = 0; i <= 9; ++i)
            count /= fact[freq[i]];
        return count;
    }
}