package _20_DynamicProgramming._4_PalindromicSubSequences.leetcode;

class demo {
    public boolean isSubsequence(String s, String t) {
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
            }
            j++;
        }
        return i == arr1.length;
    }
}