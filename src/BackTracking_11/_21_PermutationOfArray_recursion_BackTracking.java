package BackTracking_11;

import java.util.*;

public class _21_PermutationOfArray_recursion_BackTracking {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 2, 3};
        solve(0, arr, ans);
        System.out.println(ans);
    }

    private static void solve(int idx, int[] arr, List<List<Integer>> ans) {
        if (idx == arr.length - 1) {
            List<Integer> res = new ArrayList<>();
            for (int num : arr) res.add(num);
            ans.add(res);
            return;
        }
        Set<Integer> st = new HashSet<>();
        for (int i = idx; i < arr.length; i++) {
            if (!st.contains(arr[i])) {
                st.add(arr[i]);
                swap(arr, idx, i);
                solve(idx + 1, arr, ans);
                swap(arr, idx, i);
            }
        }
    }

    private static void swap(int[] arr, int idx, int i) {
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }
}
