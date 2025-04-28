package _08_Strings.medium;

class CheckPalindromeFormation_1616 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome2("abbbbbba"));
        System.out.println(checkPalindromeFormation1("x", "y"));
    }

    private static boolean checkPalindromeFormation1(String s1, String s2) {
        if (isPalindrome(s1) || isPalindrome(s2)) return true;

        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(n - i - 1)) {
                count += 2;
            } else if (count == n) {
                return true;
            } else {

            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) == s1.charAt(n - i - 1)) {
                count += 2;
            } else if (count == n) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    public static boolean checkPalindromeFormation2(String a, String b) {
//        first divide both string at 0 and then continue till length of it;
        for (int i = 0; i < a.length(); i++) {
            if (isPalindrome(a.substring(0, i) + b.substring(i))
                    || isPalindrome(b.substring(0, i) + a.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; ) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    private static boolean isPalindrome2(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}