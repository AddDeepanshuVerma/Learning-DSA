package POTD_LEETCODE.level_3;

import java.util.*;

// NOT WORKING
class MinExtraChar_2707 {
    public static void main(String[] args) {
        String str = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        String[] dictionary2 = {"lee", "ts", "co", "de", "leet", "code", "leetcode"};
        List<List<String>> lists = new ArrayList<>();

        int count = breakString2(str, dictionary2, lists);

        System.out.println("ans = " + count);
        for (List<String> list : lists) {
            System.out.println("list = " + list);
        }
    }

    private static int breakString2(String str, String[] dictionary, List<List<String>> ans) {
        Set<String> set = new HashSet<>(List.of(dictionary));
        List<String> list = new ArrayList<>();
        int count = solve2(0, str.toCharArray(), ans, list, set, 0);
        return count;
    }

    private static int solve2(int index, char[] arr, List<List<String>> ans, List<String> list, Set<String> set, int count) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(list));
            return count;
        }

        int max = count;
        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            list.add(subStr);
            max = Math.max(solve2(i + 1, arr, ans, list, set, set.contains(subStr) ? count + 1 : count), max);
            list.removeLast();
        }
        return max;
    }

}