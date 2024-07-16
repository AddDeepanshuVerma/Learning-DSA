package _08_Strings.easy;

import java.util.Arrays;
import java.util.List;

class HalvesAreAlike_1704 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String textbook) {
        int n = textbook.length();
        int count1 = checkVowelsCount(textbook.substring(0, n/2));
        int count2 = checkVowelsCount(textbook.substring(n/2));
        return count1 == count2;
    }

    private static int checkVowelsCount(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }



    public static boolean halvesAreAlike2(String s) {
        Character[] vowles = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> charList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length();
        String s1 = s.substring(0, n / 2);
        String s2 = s.substring(n / 2, n);
        return matchVowels(s1, s2, charList);
    }

    private static boolean matchVowels(String s1, String s2, List<Character> charlist) {
        int count1 = 0, count2 = 0;
        for (char c : s1.toCharArray()) {
            if (charlist.contains(c)) {
                count1++;
            }
        }
        for (char c : s2.toCharArray()) {
            if (charlist.contains(c)) {
                count2++;
            }
        }
        return count1 == count2;
    }
}