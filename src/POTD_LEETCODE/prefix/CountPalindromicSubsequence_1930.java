package POTD_LEETCODE.prefix;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;

class CountPalindromicSubsequence_1930 {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));

    }

    @Description("incorrect approach, here duplicated are also getting included")
    public static int countPalindromicSubsequence(String s) {
        char[] arr = s.toCharArray();
        // it will store that this a character was available in these indexes (of list)
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count += increaseCount(map.get(arr[i]), i);
            }
            map.computeIfAbsent(arr[i], val -> new ArrayList<>()).add(i);
        }
        return count;
    }

    private static int increaseCount(ArrayList<Integer> prevIndexes, int currIndex) {
        int count = 0;
        for (int prev : prevIndexes) {
            count += currIndex - prev - 1;
        }
        return count;
    }
}