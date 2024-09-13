package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfStrings {
    public static void main(String[] args) {
        String str = "abc";
        int idx = 0;
        List<String> list = new ArrayList<>();
        getPermutation(str.toCharArray(), idx, list);
        System.out.println("ans = " + list);

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
