package DailyCodeChallenge.Level_1;

import java.util.Stack;

class MaximumGain_1717_3 {
    public static void main(String[] args) {
        String str = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
        System.out.println(maximumGain(str, 1, 5));


    }

    public static int maximumGain(String s, int x, int y) {
        if (x > y)
            return searchElements(s, "ab", x, "ba", y);
        else
            return searchElements(s, "ba", y, "ab", x);
    }

    private static int searchElements(String str, String s1, int x, String s2, int y) {
        int score = 0;
        String str1 = deleteStr(str, s1);
        score += ((str.length() - str1.length()) >> 1) * x;
        String str2 = deleteStr(str1, s2);
        score += ((str1.length() - str2.length()) >> 1) * y;
        return score;
    }

    private static String deleteStr(String str, String s) {
        char[] arr = str.toCharArray();
        int i = 0;
        int n = s.length();
        for (int j = 0; j < arr.length; j++) {
            arr[i] = arr[j];
            i++;
            if (i >= 2 && arr[i - 2] == s.charAt(0) && arr[i - 1] == s.charAt(1)) {
                i = i - 2;
            }
        }
        return String.valueOf(arr).substring(0, i);
    }
}