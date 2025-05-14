package Contest.Biweekly_Contest._156;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q1 {

    public int maxFreqSum(String s) {
        int vowel = 0;
        int consonant = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        String vowelStr = "aeiou";

        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        for (var item : map.entrySet()) {
            Character key = item.getKey();
            int count = item.getValue();
            if (vowelStr.contains(key + "")) {
                vowel = Math.max(vowel, count);
            } else {
                consonant = Math.max(consonant, count);
            }
        }

        return vowel + consonant;
    }

    public int maxFreqSum2(String s) {
        int vowel = 0, consonant = 0;
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        HashSet<Integer> set = new HashSet<>(Set.of(0, 4, 8, 14, 20));
        for (int i = 0; i < map.length; i++) {
            if (set.contains(i)) {
                vowel = Math.max(vowel, map[i]);
            } else {
                consonant = Math.max(consonant, map[i]);
            }
        }

        return vowel + consonant;
    }

    public int maxFreqSum3(String s) {
        int vowel = 0, consonant = 0;
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        String str = "aeiou";
        for (int i = 0; i < map.length; i++) {
            char ch = (char) (i + 'a');
            if (str.indexOf(ch) != -1) {
                vowel = Math.max(vowel, map[i]);
            } else {
                consonant = Math.max(consonant, map[i]);
            }
        }

        return vowel + consonant;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
    }
}
