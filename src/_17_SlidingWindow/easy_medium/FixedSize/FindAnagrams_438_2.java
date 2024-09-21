package _17_SlidingWindow.easy_medium.FixedSize;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Description("Count Occurrences Of Anagrams | fixed size sliding window")
class FindAnagrams_438_2 {
    public static void main(String[] args) {
        System.out.println(FindAnagrams_438_2.findAnagrams2("cbacbabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] arr2 = p.toCharArray();
        int k = arr2.length;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr2) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size(); // storing unique number of elements in our anagram String

        int i = 0;
        char[] arr = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                int val = map.get(arr[j]);
                if (val == 1) count--; // value is going to be decrease to 0 in next step
                map.put(arr[j], val - 1);
            }

            if (j - i + 1 == k) {
                if (count == 0) ans.add(i);
                if (map.containsKey(arr[i])) {
                    int val = map.get(arr[i]);
                    if (val == 0) count++; // value is going to be increase from 0 next step
                    map.put(arr[i], val + 1);
                }
                i++;
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        char[] arr2 = p.toCharArray();
        int k = arr2.length;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr2) {
            map.merge(ch, 1, Integer::sum);
        }

        int i = 0;
        int count = map.size(); // storing unique number of elements in our anagram String
        char[] arr = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                if (map.get(arr[j]) == 1) count--; // value is going to be decrease to 0 in next step
                map.put(arr[j], map.get(arr[j]) - 1);
            }

            if (j - i + 1 == k) {
                if (count == 0) ans.add(i); // found the answer
                if (map.containsKey(arr[i])) { // now removed ith index to maintain window
                    if (map.get(arr[i]) == 0) count++; // value is going to be increase from 0 next step
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                i++;
            }
        }
        return ans;
    }

}