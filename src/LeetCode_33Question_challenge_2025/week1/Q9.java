package LeetCode_33Question_challenge_2025.week1;

import java.util.*;

public class Q9 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (final String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(String.valueOf(chars), list -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
