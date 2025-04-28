package POTD_LEETCODE.prefix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CountPalindromicSubsequence_1930_2 {
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));

    }

    public static int countPalindromicSubsequence(String s) {
        /*
         * need to calculate the first and last appearance of each character
         * then simply get their difference
         * */

        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (first[arr[i] - 'a'] == -1) {
                first[arr[i] - 'a'] = i;
            }
            last[arr[i] - 'a'] = i;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            // now we need to find unique chars between first i and last i
            Set<Character> bw = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                bw.add(arr[j]);
            }
            count += bw.size();
        }
        return count;
    }
}