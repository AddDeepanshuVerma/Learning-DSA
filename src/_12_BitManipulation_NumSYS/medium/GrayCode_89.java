package _12_BitManipulation_NumSYS.medium;

import java.util.ArrayList;
import java.util.List;

class GrayCode_89 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(grayCode(n));
        System.out.println(grayCode2(n));
    }

    public static List<Integer> grayCode(int n) {
        return dfs(n);
    }

    public static List<Integer> dfs(int n) {
        if (n == 1) {
            return new ArrayList<Integer>(List.of(0, 1));
        }
        List<Integer> prev = dfs(n - 1);
        List<Integer> ans = new ArrayList<>(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            ans.add(prev.get(i) | 1 << (n - 1));
        }
        return ans;
    }


    public static List<Integer> grayCode2(int n) {
        List<String> ans = dfs2(n);
        List<Integer> list = new ArrayList<>();
        for (String an : ans) {
            list.add(Integer.valueOf(an, 2));
        }
        return list;
    }

    public static List<String> dfs2(int n) {
        if (n == 1) {
            return new ArrayList<String>(List.of("0", "1"));
        }
        List<String> list = dfs2(n - 1);
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            ans.add("0" + list.get(j));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add("1" + list.get(i));
        }
        return ans;
    }
}