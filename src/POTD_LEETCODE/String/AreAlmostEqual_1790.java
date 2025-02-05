package POTD_LEETCODE.String;

class AreAlmostEqual_1790 {
    public static void main(String[] args) {
        String s1 = "siyolsdcjthwsiplccjbuceoxmpjgrauocx";
        String s2 = "siyolsdcjthwsiplccpbuceoxmjjgrauocx";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int[] map1 = new int[26], map2 = new int[26];
        int n = s1.length(), diff = 0;

        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 != ch2 && ++diff > 2) return false;
            map1[ch1 - 'a']++;
            map2[ch2 - 'a']++;
        }
        if (diff == 0) return true;

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}