package Strings.medium;

import java.util.jar.JarEntry;

class CheckPalindromeFormation_1616_2 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(checkPalindromeFormation(s1, s2));
    }
    public static boolean checkPalindromeFormation(String s1, String s2) {
        return check(s1, s2) || check(s2,s1);
    }

    public static boolean check(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0, j = n-1 ; i < n; i++, j--) {
            if (s1.charAt(i) != s2.charAt(j))
                return isPalindrome(s1, i, j) || isPalindrome(s2, i,j);
        }
        return true;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    public static boolean check2(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0, j = n-1 ; i < n; i++, j--) {
            if (s1.charAt(i) == s2.charAt(j)) {
                count += 2;
            } else if (count == n) {
                return true;
            } else {
                return isPalindrome(s1, i, j) || isPalindrome(s2, i,j);
            }
        }
        return true;
    }
}