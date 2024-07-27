package _12_BitManipulation_NumSYS.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindRepeatedDnaSequences_187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                res.add(temp);
            } else {
                set.add(temp);
            }
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> ans = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); ++i) {
            final String seq = s.substring(i, i + 10);
            if (seen.contains(seq))
                ans.add(seq);
            seen.add(seq);
        }

        return new ArrayList<>(ans);
    }

}