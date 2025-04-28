package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class OpenLock752_BFS {
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
                // forwards each wheel one by one
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
                    int ch = arr[i] - '0';
                    ch = (ch + 1) % 10;
                    arr[i] = (char) (ch + '0');

                    String v = String.valueOf(arr);
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }
                    arr[i] = temp;
                }
                // backwards each wheel one by one
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
                    int ch = arr[i] - '0';
                    ch = (ch - 1 + 10) % 10;
                    arr[i] = (char) (ch + '0');

                    String v = String.valueOf(arr);
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }
                    arr[i] = temp;
                }
            }
            level++;

        }

        return -1;
    }
}