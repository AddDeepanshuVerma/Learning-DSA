package _11_BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _12_PermutationOfString_recursion_BackTracking {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String str = "abc";
        char[] chars = str.toCharArray(); //{'1', '2', '3'};
        solve(0, chars, ans);
        System.out.println(ans);
    }

    private static void solve(int idx, char[] s, List<String> ans) {
        if (idx == s.length - 1) {
            ans.add(String.valueOf(s));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = idx; i < s.length; i++) {
            if (!set.contains(s[i])) { set.add(s[i]);
                swap(s, idx, i);
                solve(idx + 1, s, ans);
                swap(s, idx, i);
            }
        }
    }
    private static void swap(char[] s, int idx, int i) {
        char temp = s[idx];
        s[idx] = s[i];
        s[i] = temp;
    }
}
