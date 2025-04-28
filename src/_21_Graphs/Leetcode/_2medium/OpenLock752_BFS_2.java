package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class OpenLock752_BFS_2 {
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
                    char forw = (char) (((int) (ch - '0') + 1) % 10 + '0'); // forward single digit in wheel
                    char bacw = (char) (((int) (ch - '0') - 9) % 10 + '0'); // backward single digit in wheel
                    arr[i] = forw;
                    String v = String.valueOf(arr);
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }

                    arr[i] = bacw;
                    v = String.valueOf(arr);
                    if (!visited.contains(v)) {
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