package _17_SlidingWindow.easy_medium.FixedSize;

import java.security.Key;
import java.util.HashMap;

class CheckInclusion_567 {
    public boolean checkInclusion(String anagram, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : anagram.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        int count = map.size();
        int i = 0, k = anagram.length();

        char[] arr = str.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            char J = arr[j];
            if (map.containsKey(J)) {
                int val = map.merge(J, -1, Integer::sum);
                if (val == 0) count--;
            }

            if (j - i + 1 == k) {
                if(count == 0) return true;
                if (map.containsKey(arr[i])) {
                    int val = map.merge(arr[i], 1, Integer::sum);
                    if(val == 1) count++;
                }
                i++;
            }
        }
        return false;
    }
}