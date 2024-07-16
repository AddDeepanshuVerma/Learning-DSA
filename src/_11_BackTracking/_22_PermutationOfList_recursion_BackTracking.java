package _11_BackTracking;

import java.util.*;

public class _22_PermutationOfList_recursion_BackTracking {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 2, 3};
        List<Integer> lst = new ArrayList<>();
        for (int j : arr) lst.add(j);
        solve(0, lst, ans);
        System.out.println(ans);
    }

    private static void solve(int idx, List<Integer> s, List<List<Integer>> ans) {
        if (idx == s.size() - 1) {
            ans.add(new ArrayList<>(s));
            return;
        }
        Set<Integer> st = new HashSet<>();
        for (int i = idx; i < s.size(); i++) {
            if (!st.contains(s.get(i))) {
                st.add(s.get(i));
                Collections.swap(s, idx, i);
                solve(idx + 1, s, ans);
                Collections.swap(s, idx, i);
            }
        }
    }
}
