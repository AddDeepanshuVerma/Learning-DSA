package POTD_LEETCODE.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordSubsets_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        outer:
        for (String s1 : words1) {
            for (String s2 : words2) {
                if (!valid(s1, s2)) {
                    continue outer;
                }
            }
            ans.add(s1);
        }

        return ans;
    }

    private boolean valid(String s1, String s2) {
        int[] first = new int[26], second = new int[26];
        for (char ch : s1.toCharArray()) {
            first[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            second[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] < second[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean check(String s1, String s2) {
        HashMap<Character, Integer> sub = new HashMap<>();
        for (char c : s2.toCharArray()) {
            sub.merge(c, 1, Integer::sum);
        }

        HashMap<Character, Integer> source = new HashMap<>();
        for (char c : s1.toCharArray()) {
            source.merge(c, 1, Integer::sum);
        }

        for (var item : sub.entrySet()) {
            int value = item.getValue();
            if (source.getOrDefault(item.getKey(), 0) < value) {
                return false;
            }
        }
        return true;
    }
}