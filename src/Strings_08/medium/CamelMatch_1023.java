package Strings_08.medium;

import java.util.ArrayList;
import java.util.List;

class CamelMatch_1023 {
    public static void main(String[] args) {
        System.out.println(new CamelMatch_1023().check("FooBar", "FoBa"));
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (final String q : queries)
            ans.add(check(q, pattern));
        return ans;
    }

    private boolean isMatch(final String query, final String pattern) {
        int j = 0;
        for (char c : query.toCharArray())
            if (j < pattern.length() && c == pattern.charAt(j))
                ++j;
            else if (Character.isUpperCase(c))
                return false;
        return j == pattern.length();
    }

    private boolean check(String query, String pattern) {
        int i = 0, j = 0;
        /*for (char c : query.toCharArray()) {
            if (j < pattern.length() && c == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return j == pattern.length();*/
        while (i < query.length()) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (Character.isUpperCase(query.charAt(i))) {
                return false;
            } else {
                i++;
            }
        }
        return j == pattern.length();
    }
}