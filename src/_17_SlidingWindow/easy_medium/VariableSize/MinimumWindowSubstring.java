package _17_SlidingWindow.easy_medium.VariableSize;

import jdk.jfr.Description;

import java.util.HashMap;

@Description("Minimum Window Substring | Variable Size Sliding Window")
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("s = " + s);
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) map.merge(ch, 1, Integer::sum);

        int i = 0, lowerBound = -1, uperBound = -1, size = Integer.MAX_VALUE;
        int count = map.size(); // storing unique number of elements in our anagram String
        char[] arr = s.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                int temp = map.get(arr[j]);
                if (temp == 1) count--;
                map.put(arr[j], temp - 1);
            }

            while (count == 0) {
                if (j - i + 1 < size) {
                    size = j - i + 1;
                    lowerBound = i;
                    uperBound = j + 1;
                }
                if (map.containsKey(arr[i])) {
                    int temp = map.get(arr[i]);
                    if (temp == 0) count++;
                    map.put(arr[i], temp + 1);
                }
                i++;
            }
        }
        return size != Integer.MAX_VALUE ? s.substring(lowerBound, uperBound) : "";
    }
}
