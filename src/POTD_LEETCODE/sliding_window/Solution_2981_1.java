package POTD_LEETCODE.sliding_window;

import java.util.HashMap;
import java.util.Map;

class Solution_2981_1 {
    public static void main(String[] args) {
        System.out.println(maximumLength("aaaa"));
        System.out.println(maximumLength("aabcd"));
    }

    //    O(n^3)
    public static int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (temp.isEmpty() || s.charAt(j) == s.charAt(j - 1)) {
                    temp.append(s.charAt(j));
                    map.merge(temp.toString(), 1, Integer::sum);
                } else break;
            }
        }
//        System.out.println("map = " + map);
        int max = -1;

        for (var item : map.entrySet()) {
            if (item.getValue() >= 3) {
                max = Math.max(max, item.getKey().length());
            }
        }
        return max;
    }

    //    O(n^3)
    public static int maximumLength2(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (temp.isEmpty() || s.charAt(j) == s.charAt(j - 1)) {
                    temp.append(s.charAt(j));
                    int val = map.merge(temp.toString(), 1, Integer::sum); // takes O(N) to copy the N length of string in map
                    if (val >= 3) {
                        max = Math.max(max, temp.length());
                    }
                } else break;
            }
        }
        return max;
    }

    public static int maximumLength3(String s) {
        HashMap<Pair<Character, Integer>, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == ch) {
                    freq++;
                    maps.merge(new Pair<>(ch, freq), 1, Integer::sum);
                } else break;
            }
        }

        int max = -1;
        for (var item : maps.entrySet()) {
            int freq = item.getKey().freq;
            int count = item.getValue();
            if (count >= 3 && freq > max) {
                max = freq;
            }
        }
        return max;
    }

    record Pair<K, V>(K ch, V freq) {
    }
}