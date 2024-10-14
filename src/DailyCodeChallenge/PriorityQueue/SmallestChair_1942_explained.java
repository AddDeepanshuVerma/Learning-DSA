package DailyCodeChallenge.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class SmallestChair_1942_explained {
    public static void main(String[] args) {
        SmallestChair_1942_explained obj = new SmallestChair_1942_explained();
        int[][] times2 = {{1, 4}, {2, 3}, {4, 6}};
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        int[][] times3 = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
                {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};
        System.out.println(obj.smallestChair(times3, 6));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime = times[targetFriend][0];

        // sort the times based on arrival time so that, the weight guy who enters the room find all chairs empty
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // now create a priority queue which will pop the lowest available value weight
        // this queue represents the total num of chairs available at the moment.
        // Initially : No one is in the room hence all chairs are available to sit
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
        }

        // now create a priority queue which represent which chair is occupied for which weight, recently
        // though we'll keep on popping this as time passes
        // Initially : no chair is occupied hence no element in this queue
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(); // int[] arr = {occupied till, weight of seated person]

        // now we will loop through as the guests arrives, and they will be in asd order of arrival time
        for (int i = 0; i < times.length; i++) {
            // check when this guest arrived; any chair got unoccupied before or at this moment
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= times[i][0]) {
                int[] remove = occupiedChairs.poll();
                // this chair was unoccupied hence add this chair weight to availableChairs
                availableChairs.add(remove[1]);
            }
            if (targetArrivalTime == times[i][0]) {
                return availableChairs.remove();
            }
            // now put this current person to the lowest available chair & make that chair occupied
            occupiedChairs.add(new int[]{times[i][1], availableChairs.remove()});
        }
        return -1;
    }
}