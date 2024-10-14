package _17_SlidingWindow.easy_medium.VariableSize;

import java.util.HashMap;

class MinWindow_76 {
    public static String minWindow(String s, String t) {
        char[] arr2 = t.toCharArray();
        int k = arr2.length;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr2) {
            map.merge(ch, 1, Integer::sum);
        }

        int i = 0, lowerBound = -1, uperBound = -1;
        int count = map.size(); // storing unique number of elements in our anagram String
        // String ans = "";
        int size = Integer.MAX_VALUE;
        char[] arr = s.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) count--; // value is going to be decrease to 0 in next step
            }

            while (count == 0) {
                if (j - i + 1 < size) {
                    size = j - i + 1;
                    // ans = s.substring(i, j + 1);
                    lowerBound = i;
                    uperBound = j;
                }
                if (map.containsKey(arr[i])) { // now removed ith index to maintain window
                    if (map.get(arr[i]) == 0) count++; // value is going to be increase from 0 next step
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                i++;
            }

        }
        return size != Integer.MAX_VALUE ? s.substring(lowerBound, uperBound + 1) : "";
    }
}