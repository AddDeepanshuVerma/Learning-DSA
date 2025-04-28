package POTD_LEETCODE.String;

import jdk.jfr.Description;

class RemoveOccurrences_1910 {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences1(s, part));
    }

    @Description("Works as expected by prob")
    public static String removeOccurrences1(String s, String part) {
        int n = part.length();
        while (true) {
            int index = s.indexOf(part);
            if (index == -1) break;
            s = s.substring(0, index) + s.substring(index + n);
        }
        return s;
    }

    public String removeOccurrences2(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }

    public String removeOccurrences4(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    @Description("Wrong: Doesn't make sure that removed subs is first one")
    public static String removeOccurrences_(String s, String part) {
        StringBuilder ans = new StringBuilder(s);
        while (ans.indexOf(part) != -1) {
            ans.replace(0, ans.length(), part);
        }
        return ans.toString();
    }
}