package POTD_LEETCODE.prefix;

import java.util.Arrays;

class CountPalindromicSubsequence_1930_tbd {
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            int ch = first[s.charAt(i) - 'a'];
            ch = Math.min(ch, i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (first[i] < last[i]) {
                res += (int) s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        return res;
    }
}