package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class _1MinMutation_433 {
    // This solution does not pass all test cases
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    private static HashSet<String> dictionary;

    public static int minMutation(String startGene, String endGene, String[] bank) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < startGene.length(); i++) {
            if (startGene.charAt(i) != endGene.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.isEmpty()) return 0;

        dictionary = new HashSet<>(List.of(bank));
        HashSet<Integer> taken = new HashSet<Integer>();

        int ans = dfs(startGene, endGene, taken, diff);
        return ans == 0 ? -1 : ans;
    }

    private static int dfs(String startGene, String endGene, HashSet<Integer> taken, List<Integer> diff) {
        if (taken.size() == diff.size()) {
            return 0;
        }

        for (int idx : diff) {
            if (taken.contains(idx)) continue;
            String temp = startGene.substring(0, idx) + endGene.charAt(idx) + startGene.substring(idx + 1);
            taken.add(idx);
            if (dictionary.contains(temp)) {
                return 1 + dfs(temp, endGene, taken, diff);
            }
            taken.remove(idx);
        }

        return 0;
    }
}