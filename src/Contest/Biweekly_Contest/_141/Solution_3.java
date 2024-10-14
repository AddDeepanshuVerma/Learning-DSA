package Contest.Biweekly_Contest._141;

class Solution_3 {
    public int maxRemovals(String source, String pattern, int[] target) {
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            String tempS = source.substring(0, i) + "_" + source.substring(i + 1);
            if (isSubsequence(pattern, tempS)) {
                count++;
            }
        }
        return count;
    }

    static boolean isSubsequence(String pattern, String source) {
        int i = 0;
        for (int j = 0; i < pattern.length() && j < source.length(); j++) {
            if (pattern.charAt(i) == source.charAt(j)) {
                i++;
            }
        }
        return (i == pattern.length());
    }
}