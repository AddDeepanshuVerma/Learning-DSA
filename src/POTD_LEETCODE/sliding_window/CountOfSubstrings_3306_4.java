package POTD_LEETCODE.sliding_window;

import java.util.HashMap;
import java.util.Map;

class CountOfSubstrings_3306_4 {

    // using count variable to maintain how many diff vowels so far: instead of looping hashMap values
    // using a prefix array to calculate next consonant index      : instead of storing consonants index and applying binarySearch
    // isVowel function to check vowel                             : instead of asking HashMap which takes log(4)
    public static long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>(Map.of('a', 0, 'e', 0, 'i', 0, 'o', 0, 'u', 0));

        char[] arr = word.toCharArray();
        int n = arr.length, prev = n;
        int[] prefix = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prev;
            if (!isVowel(arr[i])) {
                prev = i;
            }
        }

        int i = 0, cCount = 0, vCount = 0;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (isVowel(arr[j])) {
                int val = vowels.merge(arr[j], 1, Integer::sum);
                if (val == 1) vCount++;
            } else cCount++;
            // shrink window :
            while (cCount > k) {
                if (isVowel(arr[i])) {
                    int val = vowels.merge(arr[i], -1, Integer::sum);
                    if (val == 0) { // a vowel got dissolved
                        vCount--;
                    }
                } else cCount--;
                i++;
            }
            // expedited conditions meet hence store the answers :
            while (cCount == k && vCount == 5) {
                int nextCnsnt = prefix[j];
                ans += (nextCnsnt - j);

                if (isVowel(arr[i])) {
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

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}