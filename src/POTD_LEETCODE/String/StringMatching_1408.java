package POTD_LEETCODE.String;

import java.util.ArrayList;
import java.util.List;

class StringMatching_1408 {
    public static void main(String[] args) {
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}