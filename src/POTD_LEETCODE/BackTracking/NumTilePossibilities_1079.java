package POTD_LEETCODE.BackTracking;

import java.util.HashSet;
import java.util.Set;

class NumTilePossibilities_1079 {
    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> cmbsn = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        StringBuilder curr = new StringBuilder();

        dfs(curr, tiles, cmbsn, seen);
        return cmbsn.size() - 1;
    }

    private static void dfs(StringBuilder curr, String s, Set<String> cmbsn, Set<Integer> seen) {
        cmbsn.add(curr.toString());

        for (int i = 0; i < s.length(); i++) {
            if (seen.contains(i)) continue;
            curr.append(s.charAt(i));
            seen.add(i);
            dfs(curr, s, cmbsn, seen);
            curr.deleteCharAt(curr.length() - 1);
            seen.remove(i);
        }
    }
}