package Interesting;

import java.util.Arrays;

class RankTeams_1366 {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];
        int len = votes[0].length();
        int[][] rank = new int[26][len];

        for (String vote : votes) {
            for (int j = 0; j < len; j++) {
                char ch = vote.charAt(j);
                rank[ch - 'A'][j]++;
            }
        }

        Character[] arr = new Character[len];
        for (int i = 0; i < len; i++) {
            arr[i] = votes[0].charAt(i);
        }

        Arrays.sort(arr, (a, b) -> {
            for (int i = 0; i < len; i++) {
                int chA = a - 'A', chB = b - 'A';
                if (rank[chA][i] > rank[chB][i]) return -1;
                else if (rank[chA][i] < rank[chB][i]) return 1;
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (Character ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }
}