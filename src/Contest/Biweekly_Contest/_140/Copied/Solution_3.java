package Contest.Biweekly_Contest._140.Copied;

import java.util.Arrays;

class Solution_3 {
    public int[] validSequence(String word1, String word2) {

        int[] minIndex = new int[word2.length() + 1];

        Arrays.fill(minIndex, -1);

        minIndex[minIndex.length - 1] = word2.length();

        int cIdx = word2.length() - 1;

        for (int i = word1.length() - 1; i >= 0; --i) {

            if (cIdx >= 0 && word2.charAt(cIdx) == word1.charAt(i)) {
                minIndex[cIdx] = i;
                cIdx--;
            }
        }

        int[] result = new int[word2.length()];

        int allowed = 1;
        int idx = 0;

        for (int i = 0; i < word1.length(); ++i) {

            if (idx == word2.length()) break;

            if (idx < word2.length() && word2.charAt(idx) == word1.charAt(i)) {
                result[idx++] = i;
            } else if (allowed > 0 && minIndex[idx + 1] >= i + 1) {
                allowed--;
                result[idx++] = i;
            }
        }

        return idx == word2.length() ? result : new int[]{};
    }
}