package Strings_08.easy;

class MergeAlternately_1768 {

    public String mergeAlternately2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if (i < word1.length()) {
            sb.append(word1, i, word1.length());
        }
        if (j < word2.length()) {
            sb.append(word2, j, word2.length());
        }
        return sb.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < c1.length && j < c2.length) {
            sb.append(c1[i++]);
            sb.append(c2[j++]);
        }
        if (i < c1.length) {
            sb.append(word1, i, word1.length());
        }
        if (j < c2.length) {
            sb.append(word2, j, word2.length());
        }
        return sb.toString();

    }
}