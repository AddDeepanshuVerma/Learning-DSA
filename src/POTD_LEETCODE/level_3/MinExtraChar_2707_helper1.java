package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.List;

class MinExtraChar_2707_helper1 {
    public static void main(String[] args) {
        String str = "leetscode";
        List<List<String>> ans = breakString2(str);
        for (List<String> an : ans) {
            System.out.println("an = " + an);
        }
        System.out.println("=====================================");
        List<List<String>> ans2 = breakString2(str);
        for (List<String> an2 : ans) {
            System.out.println("an2 = " + an2);
        }
    }

    private static List<List<String>> breakString(String str) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        solve(str, ans, list);
        return ans;
    }

    private static List<List<String>> breakString2(String str) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        int index = 0;
        solve2(index, str.toCharArray(), ans, list);
        return ans;
    }

    private static void solve(String str, List<List<String>> ans, List<String> list) {
        if (str.isEmpty()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        String subStr = "";
        for (int i = 0; i < str.length(); i++) {
            subStr += str.charAt(i);
            list.add(subStr);
            solve(str.substring(i + 1), ans, list);
            list.removeLast();
        }
    }

    private static void solve2(int index, char[] arr, List<List<String>> ans, List<String> list) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            list.add(subStr);
            solve2(i + 1, arr, ans, list);
            list.removeLast();
        }
    }

}