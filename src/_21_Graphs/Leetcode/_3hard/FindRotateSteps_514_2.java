package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

// NOT CORRECT SOLUTION :
/*Whenever we are using the combination of PriorityQueue & visited Hashset
then make sure that we mark we key visited only when it pops out of queue at the starting of while loop.
Reason : as if we mark that key in ngbr for loop, there might be a better case with low cost occur later which will be neglected by prior one.*/
class FindRotateSteps_514_2 {
    public int findRotateSteps(String ring, String key) {
        int n = key.length();
        int len = ring.length();

        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 26; i++) indices.add(new ArrayList<>());

        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            indices.get(ch - 'a').add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // stores : count, ringIndex, keyIndex
        HashSet<String> seen = new HashSet<>();
        pq.offer(new int[]{0, 0, 0});
        seen.add(0 + "_" + 0);

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int count = poll[0], ringIndex = poll[1], keyIndex = poll[2];
            if (keyIndex >= n) return count + key.length(); // found our answer

            char target = key.charAt(keyIndex);
            for (Integer idx : indices.get(target - 'a')) {
                String s = idx + "_" + (keyIndex + 1);
                if (!seen.contains(s)) {
                    seen.add(s);
                    int min = getCount(ring.length(), ringIndex, idx);
                    pq.offer(new int[]{count + min, idx, keyIndex + 1});
                }
            }
        }

        return -1;
    }

    private int getCount(int len, int ringIndex, Integer idx) {
        int clock = Math.abs(ringIndex - idx);
        int antiC = len - clock;
        return Math.min(clock, antiC);
    }

    public static void main(String[] args) {
        var obj = new FindRotateSteps_514_2();
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        int ans = obj.findRotateSteps(ring, key);
        System.out.println("ans = " + ans);
    }
}