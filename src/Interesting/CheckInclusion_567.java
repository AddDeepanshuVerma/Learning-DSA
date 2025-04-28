package Interesting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CheckInclusion_567 {
    public boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        getPermutation(s1.toCharArray(), 0, list);
        for (String s : list) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private static void getPermutation(char[] arr, int idx, List<String> ans) {
        if (idx == arr.length) {
            ans.add(String.valueOf(arr));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = idx; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, idx, i);
                getPermutation(arr, idx + 1, ans);
                swap(arr, idx, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}