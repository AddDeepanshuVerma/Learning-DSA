package POTD_LEETCODE.Greedy;

import java.util.PriorityQueue;

class LongestDiverseString_1405 {
    public static void main(String[] args) {
        LongestDiverseString_1405 obj = new LongestDiverseString_1405();
        System.out.println(obj.longestDiverseString(0, 8, 11));
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> p2.count - p1.count);
        pq.add(new Pair(a, 'a'));
        pq.add(new Pair(b, 'b'));
        pq.add(new Pair(c, 'c'));

        StringBuilder ans = new StringBuilder();
        Pair hold = null;
        char last = 'd';

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int count = poll.count;
            char ch = poll.ch;
            if (count == 0) continue;

            if (last != 'd' && last == ch) {
                hold = poll;
                continue;
            }
            if (count >= 2) {
                count -= 2;
                ans.append(ch).append(ch);
                pq.add(new Pair(count, ch));
            } else {
                ans.append(ch);
            }
            last = ch;

            if (hold != null) {
                pq.add(hold);
                hold = null;
            }
        }

        return ans.toString();
    }

    record Pair(int count, char ch) {
    }
}