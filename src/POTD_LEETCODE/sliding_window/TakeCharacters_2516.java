package POTD_LEETCODE.sliding_window;

import java.util.HashMap;

class TakeCharacters_2516 {
    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }

    public static int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        if (3 * k > s.length()) return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) map.merge(ch, 1, Integer::sum);
        if (map.size() < 3) return -1;
        for (Integer value : map.values()) if (value < k) return -1;

        int count = 3, i = 0;
        int maxLength = 0;
        for (int j = 0; j < arr.length; j++) {
            int val = map.merge(arr[j], -1, Integer::sum);
            if (val < k) count--;

            while (i <= j && count < 3) {
                int updatedVal = map.merge(arr[i], 1, Integer::sum);
                if (updatedVal == k) count++;
                i++;
            }
            if (count == 3) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return arr.length - maxLength;
    }
}