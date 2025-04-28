package LeetCode_33Question_challenge_2025.week1;

import java.util.Arrays;

public class Q8 {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;

        int max = 0;
        char letter = 'a';
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                letter = (char) (i + 'a');
            }
        }
        // if a char is repeated more than half times then two adjacent has to be same
        if (max > (s.length() + 1) >> 1) return "";
        char[] res = new char[s.length()];
        Arrays.fill(res, ' ');

        // now put this maxCount character with 1 difference indexes
        int idx = 0;
        while (map[letter - 'a']-- > 0) {
            res[idx] = letter;
            idx += 2;
        }
        // now fill the remaining characters
        for (int i = 0; i < map.length; i++)
            while (map[i]-- > 0) {
                if (idx >= res.length) idx = 1; // as its might be a case that letter did not cover tll end
                res[idx] = (char) (i + 'a');
                idx += 2;
            }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        var obj = new Q8();
        String ans = obj.reorganizeString("zifrfbctby");
        System.out.println(ans);
    }
}
