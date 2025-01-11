package POTD_LEETCODE.HashTable;

import java.util.ArrayList;
import java.util.List;

class WordSubsets_916_2 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] comp = createCumArr(words2); // O(26 * n)

        for (String s1 : words1) { // O(n * 36)
            if (valid(s1, comp)) {
                ans.add(s1);
            }
        }
        return ans;
    }

    // O(26 * N)
    private int[] createCumArr(String[] words2) {
        int[] prev = new int[26];

        for (String s : words2) {
            int[] curr = new int[26];
            for (char c : s.toCharArray()) {
                curr[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                prev[i] = Math.max(prev[i], curr[i]);
            }
        }
        return prev;
    }

    // O(10 + 26)
    private boolean valid(String s1, int[] second) {
        int[] first = new int[26];
        for (char ch : s1.toCharArray()) {
            first[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] < second[i]) {
                return false;
            }
        }
        return true;
    }
}