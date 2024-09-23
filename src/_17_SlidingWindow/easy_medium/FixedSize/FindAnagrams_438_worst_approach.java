package _17_SlidingWindow.easy_medium.FixedSize;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Description("Count Occurrences Of Anagrams | fixed size sliding window")
class FindAnagrams_438_worst_approach {
    public static void main(String[] args) {
        System.out.println(FindAnagrams_438_worst_approach.findAnagrams2("cbacbabacd", "abc"));
    }

    // worst approach possible - brute force approach
    public static List<Integer> findAnagrams2(String s, String p) {
        int i = 0;
        int k = p.length();

        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        p = String.valueOf(arr);

        List<Integer> ans = new ArrayList<>();
        String sb = "";
        for (int j = 0; j < s.length(); j++) {
            sb += s.charAt(j);
            if (j - i + 1 == k) {
                String clone = sb;
                char[] temp = sb.toCharArray();
                Arrays.sort(temp);
                sb = String.valueOf(temp);
                if (p.equals(sb)) {
                    ans.add(i);
                }
                sb = clone.substring(1);
                i++;
            }
        }
        return ans;
    }
}