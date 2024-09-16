package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;

class Partition_131 {
    static List<List<String>> list;

    public static void main(String[] args) {
        Partition_131 obj = new Partition_131();
        List<List<String>> list = obj.partition("aaa");
        for (List<String> sublist : list) {
            System.out.println("sublist = " + sublist);
        }
    }

    private List<List<String>> partition(String s) {
        list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int index = 0;
        solve(s, index, temp);
        return list;
    }

    private void solve(String st, int index, List<String> temp) {
        if (index == st.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        String pal = "";
        for (int i = index; i < st.length(); i++) {
            pal += st.charAt(i);
            if (isPalindrome(pal)) {
                temp.add(pal);
                solve(st, i + 1, temp);
                temp.removeLast();
            }
        }
    }

    private boolean isPalindrome2(String pal) {
        char[] arr = pal.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}