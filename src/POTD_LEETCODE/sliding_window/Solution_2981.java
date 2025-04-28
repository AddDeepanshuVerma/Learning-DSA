package POTD_LEETCODE.sliding_window;

import java.util.HashMap;

class Solution_2981 {
    public static void main(String[] args) {
        System.out.println(maximumLength("aaaa"));
    }

    public static int maximumLength(String s) {
        /*
         * Find such subStrings from s which are special & sun another exists thrice or not loop on that substring
         * */
        int max = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            map.merge(s.charAt(j), 1, Integer::sum);
            while (map.size() > 1) {
                int val = map.merge(s.charAt(i), -1, Integer::sum);
                if (val == 0) map.remove(s.charAt(i));
                i++;
            }
            if (map.size() == 1) {
//                search if current substring from [i,j] exists thrice in s
                if (search(s, i, j)) max = Math.max(max, (j - i + 1));
            }
        }
        return max;
    }

    public static boolean search(String s, int start, int end) {
//        int subLength = end - start + 1;
//        if (subLength > (s.length() / 3)) return false;
        String substring = s.substring(start, end + 1);

        //now check the occurrences of subString in s
        int count = 0;
        int fromIndex = 0;
        while (true) {
            int index = s.indexOf(substring, fromIndex);
            if (index == -1) break;
            fromIndex = index + 1;
            count++;
            if (count == 3) return true;
        }
        return false;
    }
}