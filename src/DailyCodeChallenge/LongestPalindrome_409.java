package DailyCodeChallenge;

import java.util.*;

public class LongestPalindrome_409 {
    public static void main(String[] args) {
        int res = longestPalindrome("abcccccdd");
        System.out.println(res);
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> set = map.keySet();
        List<Integer> values = map.values().stream().toList();
        int sum = 0;
        int carry = 0;
        for (Character c : set) {
            Integer i = map.get(c);
            sum += i / 2;
            if (carry != 1) {
                carry = i % 2;
            }
        }
        return 2 * sum + carry;
    }
}
