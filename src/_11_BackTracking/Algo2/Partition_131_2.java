package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;

class Partition_131_2 {

    public static void main(String[] args) {
        Partition_131_2 obj = new Partition_131_2();
        List<List<String>> list = obj.partition("aaaa");
        for (List<String> sublist : list) {
            System.out.println("sublist = " + sublist);
        }
    }

    private List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        solve(s.toCharArray(), 0, new ArrayList<>(), list);
        return list;
    }

    private void solve(char[] arr, int index, List<String> path, List<List<String>> list) {
        if (index == arr.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        String pal = "";
        for (int i = index; i < arr.length; i++) {
            pal += arr[i];
            if (isPalindrome(pal)) {
                path.add(pal);
                solve(arr, i + 1, path, list);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String pal) {
        char[] arr = pal.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }

}