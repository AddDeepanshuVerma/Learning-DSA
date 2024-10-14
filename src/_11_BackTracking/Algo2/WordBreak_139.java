package _11_BackTracking.Algo2;

import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        return solve(s.toCharArray(), index, new HashSet<>(wordDict));
    }

    private boolean solve(char[] arr, int index, HashSet<String> set) {
        if (index == arr.length) {
            return true;
        }

        String prefix = "";
        for (int i = index; i < arr.length; i++) {
            prefix += arr[i];
            if (set.contains(prefix)) {
                if (solve(arr, i + 1, set)) {
                    return true;
                }
            }
        }
        return false;
    }

}