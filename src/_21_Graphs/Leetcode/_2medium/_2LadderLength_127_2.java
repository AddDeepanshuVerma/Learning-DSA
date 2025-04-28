package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class _2LadderLength_127_2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return 0;
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();

        q.addLast(beginWord);
        visited.add(beginWord);
        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int size = q.size();

            while (size-- > 0) {
                String s = q.removeFirst();
                if (s.equals(endWord)) return count;

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    for (int j = 0; j < s.length(); j++) {
                        char[] arr = s.toCharArray();
                        arr[j] = ch;
                        String temp = String.valueOf(arr);
                        if (dictionary.contains(temp) & !visited.contains(temp)) {
                            visited.add(temp);
                            q.addLast(temp);
                        }
                    }

                }

            }
        }
        return 0;
    }
}