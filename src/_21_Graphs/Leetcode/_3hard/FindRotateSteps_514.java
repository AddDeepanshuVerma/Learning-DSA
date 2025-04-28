package _21_Graphs.Leetcode._3hard;

import java.util.ArrayDeque;

// n^2 :: TLE
class FindRotateSteps_514 {
    public int findRotateSteps(String ring, String key) {
        int n = key.length();
        int len = ring.length();

        int min = Integer.MAX_VALUE;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(ring, 0, 0));

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            String str = poll.str;
            int idx = poll.idx;
            int count = poll.count;

            while (idx < n && key.charAt(idx) == str.charAt(0)) idx++;
            if (idx >= n) { // found our answer
                min = Math.min(min, count);
                continue; // no need to explore further for this node of deque
            }

            int first = str.indexOf(key.charAt(idx));
            int last = str.lastIndexOf(key.charAt(idx));

            q.offer(new Pair(str.substring(first) + str.substring(0, first), idx + 1, count +Math.min(first, len - first)));
            if (first != last) { // there are multiple such element
                q.offer(new Pair(str.substring(last) + str.substring(0, last), idx + 1, count + Math.min(last, len - last)));
            }
        }

        return min + key.length();
    }

    record Pair(String str, Integer idx, Integer count) {

    }

    public static void main(String[] args) {
        var obj = new FindRotateSteps_514();
        String ring = "godding";
        String key = "godding";
        int ans = obj.findRotateSteps(ring, key);
        System.out.println("ans = " + ans);
    }
}