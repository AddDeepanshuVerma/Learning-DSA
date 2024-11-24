package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinExtraChar_2707_helper2 {
    static long max;
    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        String str = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        List<List<String>> ans2 = breakStringWithCond(str, dictionary);
        for (List<String> an2 : ans2) {
            System.out.println("an2 = " + an2);
        }
    }

    private static List<List<String>> breakStringWithCond(String str, String[] dictionary) {
        Set<String> set = new HashSet<>(List.of(dictionary));
        List<String> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        solve(str, ans, temp, set);
        return ans;
    }

    private static void solve(String str, List<List<String>> ans, List<String> temp, Set<String> set) {
        if (str.isEmpty()) {
            /*if (temp.stream().map(set::contains).count() == 2) {
                ans.add(new ArrayList<>(temp));
            }*/
            if (temp.stream().filter(set::contains).count() == 2) {
                ans.add(new ArrayList<>(temp));
            }
            /*int count = 0;
            for (String s : temp) {
                if (set.contains(s)) count++;
            }
            if (count == 2) ans.add(new ArrayList<>(temp));*/
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            temp.add(str.substring(0, i + 1));
            solve(str.substring(i + 1), ans, temp, set);
            temp.removeLast();
        }
    }

    private static void solve2(String str, List<List<String>> ans, List<String> temp, Set<String> set) {
        if (str.isEmpty()) {
            /*if (temp.stream().map(set::contains).count() == 2) {
                ans.add(new ArrayList<>(temp));
            }*/
            /*if (temp.stream().filter(set::contains).count() == 2) {
                ans.add(new ArrayList<>(temp));
            }*/
            ans.add(new ArrayList<>(temp));
            return;
        }
        String subS = "";
        for (int i = 0; i < str.length(); i++) {
            subS += str.charAt(i);
            temp.add(subS);
            solve2(str.substring(i + 1), ans, temp, set);
            temp.removeLast();
        }
    }

    private static void solve3(String str, List<List<String>> ans, List<String> temp, Set<String> set) {
        if (str.isEmpty()) {
            long count = temp.stream().filter(set::contains).count();
            if (count > max) {
//                ans.clear();
                max = count;
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        String subS = "";
        for (int i = 0; i < str.length(); i++) {
            subS += str.charAt(i);
            temp.add(subS);
            solve3(str.substring(i + 1), ans, temp, set);
            temp.removeLast();
        }
    }
}