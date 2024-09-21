package _17_SlidingWindow.easy_medium.VariableSize;

import jdk.jfr.Description;

import java.util.HashSet;
import java.util.Set;

@Description("Longest Substring With Without Repeating Characters")
class LongestUniqueSubsttr_gfg {
    public static void main(String[] args) {
        LongestUniqueSubsttr_gfg obj = new LongestUniqueSubsttr_gfg();
        System.out.println(obj.longestUniqueSubsttr("geeksforgeeks"));
    }

    int longestUniqueSubsttr(String str) {
        Set<Character> set = new HashSet<>();
        int i = 0, length = 0;
        char[] arr = str.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            while (!set.isEmpty() && set.contains(arr[j])) {
                set.remove(arr[i]);
                i++;
            }
            // arr[j] will be added only if it is not there in the set already
            // if it does, we'll keep on removing the ith index one by one
            set.add(arr[j]);
            length = Math.max(length, j - i + 1);
        }
        return length;
    }
}