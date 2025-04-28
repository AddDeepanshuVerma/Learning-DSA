package _11_BackTracking.Algo2;

import java.util.HashSet;
import java.util.List;

class WordBreak_139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        return solve(s.toCharArray(), index, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    private boolean solve(char[] arr, int index, HashSet<String> set, Boolean[] mem) {
        if (index == arr.length) {
            return true;
        }
        if (mem[index] != null) {
            return mem[index];
        }

        String prefix = "";
        for (int i = index; i < arr.length; i++) {
            prefix += arr[i];
            if (set.contains(prefix) && solve(arr, i + 1, set, mem)) {
                return mem[index] = true;
            }
        }
        return mem[index] = false;
    }

}