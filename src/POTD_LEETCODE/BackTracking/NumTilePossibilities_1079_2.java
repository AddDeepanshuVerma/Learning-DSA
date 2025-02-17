package POTD_LEETCODE.BackTracking;

import java.util.HashSet;
import java.util.Set;

class NumTilePossibilities_1079_2 {
    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> cmbsn = new HashSet<>();
        boolean[] seen = new boolean[tiles.length()];
        StringBuilder curr = new StringBuilder();

        dfs(curr, tiles, cmbsn, seen);
        return cmbsn.size() - 1;
    }

    private static void dfs(StringBuilder curr, String s, Set<String> cmbsn, boolean[] seen) {
        cmbsn.add(curr.toString());

        for (int i = 0; i < s.length(); i++) {
            if (seen[i]) continue;
            curr.append(s.charAt(i));
            seen[i] = true;
            dfs(curr, s, cmbsn, seen);
            curr.deleteCharAt(curr.length() - 1);
            seen[i] = false;
        }
    }
}