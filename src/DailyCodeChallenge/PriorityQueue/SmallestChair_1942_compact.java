package DailyCodeChallenge.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class SmallestChair_1942_compact {
    public static void main(String[] args) {
        SmallestChair_1942_compact obj = new SmallestChair_1942_compact();
        int[][] times2 = {{1, 4}, {2, 3}, {4, 6}};
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        int[][] times3 = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
                {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};
        System.out.println(obj.smallestChair(times3, 6));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
        }
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] time : times) {
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time[0]) {
                int[] remove = occupiedChairs.poll();
                availableChairs.add(remove[1]);
            }
            if (targetArrivalTime == time[0]) {
                break;
            }
            occupiedChairs.add(new int[]{time[1], availableChairs.remove()});
        }
        return !availableChairs.isEmpty() ? availableChairs.peek() : -1;
    }
}