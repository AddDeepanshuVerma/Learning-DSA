package LeetCode_33Question_challenge_2025.week1;

import java.util.Arrays;

public class Q6 {
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

        StringBuilder sb = new StringBuilder(Arrays.toString(arr));
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"ACBD", "ACBD", "ACBD", "ADBC", "BDCA"};
        var obj = new Q6();
        String ans = obj.rankTeams(votes);
        System.out.println("ans = " + ans);
    }
}
