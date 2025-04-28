package Contest.Weekly_Contest._446;

import java.util.HashSet;

public class Q1 {

    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i = 0, n = instructions.length;
        HashSet<Integer> visited = new HashSet<>();

        while (i >= 0 && i < n) {
            if (visited.contains(i)) break;
            visited.add(i);

            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            } else {
                i += values[i];
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
    }
}
