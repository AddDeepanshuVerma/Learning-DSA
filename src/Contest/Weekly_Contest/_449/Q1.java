package Contest.Weekly_Contest._449;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Q1 {

    public int minDeletion2(String s, int k) {
        int len = 0;
        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
            if (set.size() > k) break;
            len++;
        }

        return s.length() - len;
    }

    public int minDeletion3(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int i = 0, len = 0;

        for (int j = 0; j < arr.length; j++) {
            map.merge(arr[j], 1, Integer::sum);

            if (map.size() > k) {
                int val = map.merge(arr[i], -1, Integer::sum);
                if (val == 0) map.remove(arr[i]);
                i++;
            }

            if (map.size() <= k) {
                len = Math.max(len, j - i + 1);
            }

        }

        return s.length() - len;
    }

    public int minDeletion(String s, int k) {
        char[] arr = s.toCharArray();
        int[] map = new int[26];

        for (char ch : arr) map[ch - 'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); // {value}
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                pq.offer(map[i]);
            }
        }

        System.out.println("pq = " + pq);
        int remove = 0;
        while (!pq.isEmpty() && pq.size() > k) {
            remove += pq.poll();
        }

        return remove;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
        int ans = obj.minDeletion("abc", 2);
        System.out.println("ans = " + ans);
    }
}
