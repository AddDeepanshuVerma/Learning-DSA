package DailyCodeChallenge.Level_2;

import java.util.HashSet;

class StrangePrinter_664 {
    public int strangePrinter(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        return set.size();
    }

}