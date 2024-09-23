package DailyCodeChallenge.level_3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
// not working
class MinExtraChar_2707_2 {
    public static void main(String[] args) {
        String str = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        String[] dictionary2 = {"lee", "ts", "co", "de", "leet", "code", "leetcode"};

        Pair ans = breakString2(str, dictionary2);
        System.out.println("ans = " + ans);
    }

    static class Pair {
        int max;
        int length;

        @Override
        public String toString() {
            return "Max{" + "max=" + max + ", length=" + length + '}';
        }

        public Pair(int max, int length) {
            this.max = max;
            this.length = length;
        }
    }

    private static Pair breakString2(String str, String[] dictionary) {
        Set<String> set = new HashSet<>(List.of(dictionary));
        Pair max = new Pair(0, 0);
        solve2(0, str.toCharArray(), set, max);
        return max;
    }

    private static Pair solve2(int index, char[] arr, Set<String> set, Pair pair) {
        if (index == arr.length) {
            return pair;
        }

        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            if (set.contains(subStr)) {
                pair.max++;
                pair.length += subStr.length();
            }
            Pair pair2 = solve2(i + 1, arr, set, pair);

            if (pair2.max > pair.max) {
                pair = pair2;
            }
            if (set.contains(subStr)) {
                pair.max--;
                pair.length -= subStr.length();
            }

        }
        return pair;
    }

}