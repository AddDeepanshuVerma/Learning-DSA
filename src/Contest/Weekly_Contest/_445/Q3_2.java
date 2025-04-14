package Contest.Weekly_Contest._445;

import _19_TRIE.hard.Solution;

public class Q3_2 {
    private static final long THRESHOLD = 1_000_001L;

    // Computes nCr with early exit if result exceeds threshold
    private long cmb(int n, int r) {
        if (r > n) return 0;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > THRESHOLD) return THRESHOLD;
        }
        return res;
    }

    // Calculates total permutations of multiset of letters (used for palindrome halves)
    private long calc(int[] a, int tot) {
        long res = 1;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0) {
                res *= cmb(tot, a[i]);
                if (res > THRESHOLD) return THRESHOLD;
                tot -= a[i];
            }
        }
        return res;
    }

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        char middleChar = 0;
        int[] halfFreq = new int[26];
        int totalHalfLength = 0;

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
            totalHalfLength += halfFreq[i];
            if (freq[i] % 2 == 1) middleChar = (char) ('a' + i);
        }

        long totalComb = calc(halfFreq.clone(), totalHalfLength);
        if (k > totalComb) return "";

        StringBuilder leftHalf = new StringBuilder();

        while (totalHalfLength > 0) {
            for (int i = 0; i < 26; i++) {
                if (halfFreq[i] > 0) {
                    halfFreq[i]--;
                    long w = calc(halfFreq, totalHalfLength - 1);
                    if (w >= k) {
                        leftHalf.append((char) ('a' + i));
                        totalHalfLength--;
                        break;
                    } else {
                        k -= w;
                        halfFreq[i]++;
                    }
                }
            }
        }

        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        if (middleChar != 0) {
            return leftHalf.toString() + middleChar + rightHalf.toString();
        } else {
            return leftHalf.toString() + rightHalf.toString();
        }
    }

    public static void main(String[] args) {
        Q3_2 sol = new Q3_2();
        System.out.println(sol.smallestPalindrome("aabb", 1));  // Output: "abba"
        System.out.println(sol.smallestPalindrome("aabb", 2));  // Output: "baab"
        System.out.println(sol.smallestPalindrome("aabc", 1));  // Output: ""
    }
}
