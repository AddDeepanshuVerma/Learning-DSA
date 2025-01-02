package POTD_LEETCODE.prefix;

import java.util.Set;

class VowelStrings_2559 {
    public static void main(String[] args) {

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] prefix = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count++;
            }
            prefix[i] = count;
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] == 0 ? 0 : prefix[queries[i][0] - 1];
            int right = prefix[queries[i][1]];
            res[i] = right - left;
        }
        return res;
    }
}