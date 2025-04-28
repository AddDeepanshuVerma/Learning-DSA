package POTD_LEETCODE.sliding_window;

import java.util.*;

class CountOfSubstrings_3306_3 {
    //using count variable to maintain how many diff vowels so far
    //using a prefix array to calculate next consonant index
    public static long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>(Map.of('a', 0, 'e', 0, 'i', 0, 'o', 0, 'u', 0));

        // need to store the index of
        char[] arr = word.toCharArray();
        int n = arr.length;

        int[] prefix = new int[n];
        int prev = n;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prev;
            if (!vowels.containsKey(arr[i])) {
                prev = i;
            }
        }

        int i = 0, cCount = 0, vCount = 0;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (vowels.containsKey(arr[j])) {
                int val = vowels.merge(arr[j], 1, Integer::sum);
                if (val == 1) { // a new vowel was achieved
                    vCount++;
                }
            } else cCount++;

            while (cCount > k) {
                if (vowels.containsKey(arr[i])) {
                    int val = vowels.merge(arr[i], -1, Integer::sum);
                    if (val == 0) { // a vowel got dissolved
                        vCount--;
                    }
                } else cCount--;
                i++;
            }

            while (cCount == k && vCount == 5) {
                int nextCnsnt = prefix[j];
                ans += (nextCnsnt - j);

                if (vowels.containsKey(arr[i])) {
                    int val = vowels.merge(arr[i], -1, Integer::sum);
                    if (val == 0) { // a vowel got dissolved
                        vCount--;
                    }
                } else cCount--;
                i++;
            }
        }
        return ans;
    }

}