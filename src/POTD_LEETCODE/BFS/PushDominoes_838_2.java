package POTD_LEETCODE.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;

// Problem converted to Graph : passed all test cases
class PushDominoes_838_2 {
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ans = new char[n];
        Arrays.fill(ans, '.');

        ArrayDeque<int[]> q = new ArrayDeque<>(); // stores {currIndex, time, direction}
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.') continue;
            q.offer(new int[]{i, 1, dominoes.charAt(i) - 'A'});
            ans[i] = dominoes.charAt(i);
            time[i] = 1;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] poll = q.poll();
                int idx = poll[0];
                int t = poll[1];
                char dir = (char) (poll[2] + 'A');

                int nextIdx = dir == 'L' ? idx - 1 : idx + 1;
                if (nextIdx < 0 || nextIdx >= n || time[nextIdx] < t + 1) continue;
                if (t + 1 < time[nextIdx]) {
                    time[nextIdx] = t + 1;
                    ans[nextIdx] = dir;
                    q.offer(new int[]{nextIdx, time[nextIdx], poll[2]});
                } else if (t + 1 == time[nextIdx]) {
                    if (ans[nextIdx] != dir) {
                        ans[nextIdx] = '.';
                    }
                }
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String ans = pushDominoes(".L.R...LR..L..");
        System.out.println("ans = " + ans);
    }
}