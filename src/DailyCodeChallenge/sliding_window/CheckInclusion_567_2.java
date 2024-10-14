package DailyCodeChallenge.sliding_window;

import java.util.Arrays;
import java.util.HashMap;

class CheckInclusion_567_2 {
    public boolean checkInclusion(String anagram, String str) {
        if (anagram.length() > str.length()) return false;

        char[] arr1 = anagram.toCharArray();
        char[] arr2 = str.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s1 = String.valueOf(arr1);
        String s2 = String.valueOf(arr2);

        return s2.contains(s1);
    }
}