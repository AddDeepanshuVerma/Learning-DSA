package Strings_08.easy;

class ValidPalindrome_680 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aabbccbbaa", 0, 9));

    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--)) return false;
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
        }
        return true;
        /*int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            else {
                i++;j--;
            }
        }
        return true;*/
    }

    public boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
                /*if(isPalindrom(s, i, j) || isPalindrom(s, i + 1, j + 1)){
                    return true;
                }else {
                    return false;
                }*/

                /*if (isPalindrom(s, i, j)) {
                    return true;
                } else {
                    if (isPalindrom(s, i + 1, j + 1)) {
                        return true;
                    } else {
                        return false;
                    }
                }*/
            }
        }
        return true;
    }
}