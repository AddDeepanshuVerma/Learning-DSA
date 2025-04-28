package LeetCode_33Question_challenge_2025.week1;

import java.util.Arrays;
import java.util.HashSet;

class Q5 {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int[] last = new int[26];

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (first[ch - 'a'] == -1) {
                first[ch - 'a'] = i; // stores first index of this character
            } else {
                last[ch - 'a'] = i; // stores first index of this character
            }
        }
        return getCount(first, last, arr);
    }

    private static int getCount(int[] first, int[] last, char[] arr) {
        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            // here we will compare the first and last occurance of this char & store the inBetween gap
            int start = first[ch - 'a'];
            int end = last[ch - 'a'];
            if (start == -1 || (start == end)) continue;
            // now we know this char occurs more than one time hence store the count of
            // different distinct character between them
            HashSet<Character> set = new HashSet<>();
            for (int i = start + 1; i <= end - 1; i++) {
                set.add(arr[i]);
            }
            count += set.size();
        }
        return count;
    }
}