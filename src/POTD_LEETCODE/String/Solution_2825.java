package POTD_LEETCODE.String;

class Solution_2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j) || (((str1.charAt(i) - 'a' + 1) % 26) + 'a') == str2.charAt(j)) {
                j++;
                if (j == str2.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMakeSubsequence2(String str1, String str2) {
        int j = 0;
        for (char ch : str1.toCharArray()) {
            char ch2 = str2.charAt(j);
            if (ch == ch2 || ((ch - 'a' + 1) % 26) + 'a' == ch2) {
                j++;
                if (j == str2.length()) return true;
            }
        }
        return false;
    }
}