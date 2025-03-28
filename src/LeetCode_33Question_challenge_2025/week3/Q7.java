package LeetCode_33Question_challenge_2025.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q7 {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j : freq) {
            if (j > 0) pq.offer(j);
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= (n + 1); i++) {
                if (!pq.isEmpty()) list.add(pq.poll() - 1);
            }
            for (int nFreq : list)
                if (nFreq > 0) pq.add(nFreq);
            time += pq.isEmpty() ? list.size() : (n + 1);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'};
        int ans = leastInterval(tasks, 1);
        System.out.println("ans = " + ans);
    }
}
