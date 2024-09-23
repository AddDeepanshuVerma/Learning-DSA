package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak2_140 {
    public static void main(String[] args) {
        List<String> list = WordBreak2_140.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        System.out.println("list = " + list);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int index = 0;
        solve(index, s.toCharArray(), temp, res, set);
        return res;
    }

    private static void solve(int index, char[] charArray, List<String> temp, List<String> res, Set<String> set) {
        if (index == charArray.length) {
            res.add(String.join(" ", temp));
            return;
        }
        String subString = "";
        for (int i = index; i < charArray.length; i++) {
            subString += charArray[i];
            if (set.contains(subString)) {
                temp.add(subString);
                solve(i + 1, charArray, temp, res, set);
                temp.removeLast();
            }
        }
    }
}