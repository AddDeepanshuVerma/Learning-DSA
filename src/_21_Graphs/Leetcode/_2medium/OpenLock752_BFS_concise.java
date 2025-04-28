package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class OpenLock752_BFS_concise {
    public int openLock(String[] deadends, String target) {
        String source = "0000";

        HashSet<String> visited = new HashSet<>(List.of(deadends));
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(source);
        if (!visited.add(source)) return -1;

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String u = q.removeFirst();
                if (u.equals(target)) return level;

                char[] arr = u.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];
                    for (int move : new int[]{1, -1}) {
                        arr[i] = (char) (((int) (ch - '0') + move + 10) % 10 + '0'); // forward & backward single digit in wheel
                        String v = String.valueOf(arr);
                        if (visited.contains(v)) continue;
                        visited.add(v);
                        q.offer(v);
                    }
                    arr[i] = ch;
                }
            }
            level++;
        }

        return -1;
    }
}