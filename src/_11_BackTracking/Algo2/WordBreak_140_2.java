package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak_140_2 {
    public static void main(String[] args) {
        WordBreak_140_2 obj = new WordBreak_140_2();

        String str = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        List<String> list = obj.wordBreak(str, wordDict);
        System.out.println("list = " + list);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        solve(s.toCharArray(), 0, new ArrayList<>(), wordSet, res);
        return res;
    }

    private void solve(char[] arr, int index, ArrayList<String> temp, Set<String> wordSet, List<String> res) {
        if (index == arr.length) res.add(String.join(" ", temp));
        else {
            String check = "";
            for (int i = index; i < arr.length; i++) {
                check += arr[i];
                if (wordSet.contains(check)) {
                    temp.add(check);
                    solve(arr, i + 1, temp, wordSet, res);
                    temp.removeLast();
                }
            }
        }
    }
}