package DailyCodeChallenge.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class AssignTasks_1882_tbd {
    public static void main(String[] args) {
        int[] server = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] ans = assignTasks(server, tasks);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];

        PriorityQueue<Pair> available = new PriorityQueue<>((a, b) -> a.weight != b.weight ? a.weight - b.weight : a.index - b.index);// { weight, index }
        PriorityQueue<Trio> unavailable = new PriorityQueue<>((a, b) -> a.timeFree - b.timeFree); // { weight, time till busy }

        // Initially all servers are available hence
        for (int i = 0; i < servers.length; i++)
            available.add(new Pair(servers[i], i));

        int time = 0, i = 0;
        while (true) {
            time = Math.max(time, i);
            if (available.isEmpty()) {
                 time = unavailable.peek().timeFree;
//                Trio poll = unavailable.poll();
//                time = poll.timeFree;
//                available.add(new Pair(poll.weight, poll.index));
//                continue;
            }
            while (!unavailable.isEmpty() && unavailable.peek().timeFree <= time) {
                Trio poll = unavailable.poll();
                available.add(new Pair(poll.weight, poll.index));
            }
            Pair free = available.poll();
            res[i] = free.index;
            unavailable.add(new Trio(time + tasks[i], free.weight, free.index));
            i++;
            if(i == res.length) break;
        }
        return res;
    }

    static record Pair(int weight, int index) {
    }

    static record Trio(int timeFree, int weight, int index) {
    }
}