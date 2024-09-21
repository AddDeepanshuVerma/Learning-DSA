package _17_SlidingWindow.easy_medium.VariableSize;

import jdk.jfr.Description;

import java.util.HashMap;

@Description("Longest K unique characters substring")
public class LongestkSubstr_gfg {
    public static void main(String[] args) {
        LongestkSubstr_gfg obj = new LongestkSubstr_gfg();
        System.out.println(obj.longestkSubstr("ababc", 2));
    }

    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int i = 0, length = 0;
        for (int j = 0; j < arr.length; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > k) {
                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
                i++;
            }
            if (map.size() == k) {
                length = Math.max(length, j - i + 1);
            }
        }
        return length;
    }
}