package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class SmallestChair_1942 {
    public static void main(String[] args) {
        SmallestChair_1942 obj = new SmallestChair_1942();
        int[][] times2 = {{1, 4}, {2, 3}, {4, 6}};
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        int[][] times3 = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
                {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};
        System.out.println(obj.smallestChair(times3, 6));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Pair> arrival = new PriorityQueue<Pair>((a, b) -> a.time - b.time);
        PriorityQueue<Pair> leave = new PriorityQueue<Pair>((a, b) -> a.time - b.time);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < times.length; i++) {
            arrival.add(new Pair(times[i][0], i));
            leave.add(new Pair(times[i][1], i));
            max = Math.max(max, Math.max(times[i][0], times[i][1]));
        }
        for (int i = 0; i <= max; i++) pq.add(i);

//        for (int i = 0; i < arrival.size(); i++) {
        while (!arrival.isEmpty()) {
            Pair arrive = arrival.remove();
            while (!leave.isEmpty() && leave.peek().time <= arrive.time) {
                pq.add(leave.remove().index);
            }

            int firstEmpty = pq.remove();
            if (arrive.index == targetFriend) {
                return firstEmpty;
            }
        }
        return -1;
    }

    private record Pair(Integer time, Integer index) {
    }
}