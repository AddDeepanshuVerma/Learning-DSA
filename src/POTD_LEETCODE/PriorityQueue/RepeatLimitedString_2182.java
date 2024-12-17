package POTD_LEETCODE.PriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

class RepeatLimitedString_2182 {
    public static void main(String[] args) {
        String s = "aaaabbbbccccdddd";
        System.out.println(repeatLimitedString(s, 2));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.merge(ch, 1, Integer::sum);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (var item : map.entrySet()) {
            pq.offer(new Pair(item.getKey(), item.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        char pChar = 0;
        int pCount = 0;

        while (!pq.isEmpty()) {
            if (pCount <= 0) {
                Pair poll = pq.poll();
                char ch = poll.getKey();
                int count = poll.getValue();
                int repeat = repeatLimit;
                while (repeat-- > 0 && count-- > 0) {
                    sb.append(ch);
                }
                if (count > 0) {
                    pChar = ch;
                    pCount = count;
                }
            } else {
                Pair poll = pq.poll();
                char ch = poll.getKey();
                int count = poll.getValue();

                sb.append(ch);
                count--;
                if (count > 0) {
                    pq.offer(new Pair(ch, count));
                }
                int repeat = repeatLimit;
                while (repeat-- > 0 && pCount-- > 0) {
                    sb.append(pChar);
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    record Pair(char getKey, int getValue) {
    }
}