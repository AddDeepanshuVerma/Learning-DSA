package DailyCodeChallenge.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class AssignTasks_1882 {
    public static void main(String[] args) {
        int[] server = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] ans = assignTasks(server, tasks);
        System.out.println(Arrays.toString(ans));
    }

    // does not work 30/36 TC passed!!!!
    // FOUND THE DEEP REASON:
    // jaise hi hmara time current (first unavailable ka wait krte krte) ith index se kafi aage chla gua ho
    // , to hum usse tb tk increase nahi krenge jb tk ya to vo current index se chhota na ho or again koi
    // unavailable index use bda na kr de
    // What was wrong : jb ek baar i = 5 tha and time 5 se bdh ke 10 ho gya to hum use again 11, 12, 13... kr rhe the
    // jbki vo 10 tk hi rhe tb bhi kafi index process kr dega hence time = max(time, i): i se chhota hote hi i ke brabr hoga ye
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];

        PriorityQueue<Pair> free = new PriorityQueue<>((a, b) -> a.server != b.server ? a.server - b.server : a.index - b.index);// { weight, serverIndex }
        PriorityQueue<Trio> used = new PriorityQueue<>((a, b) -> a.tillTime - b.tillTime); // { weight, time till busy }

        // Initially all servers are available hence
        for (int i = 0; i < servers.length; i++)
            free.add(new Pair(servers[i], i));

        // Initially none weight is busy hence nothing to add
        int time = 0, i = 0;
        while (true) {
            while (!used.isEmpty() && used.peek().tillTime <= time) {
                Trio trio = used.poll();
                free.add(new Pair(trio.server, trio.index));
            }
            if (free.isEmpty() && !used.isEmpty()) {
                time = used.peek().tillTime;
                continue;
            }

            // now put our ith weight the available weight
            Pair poll = free.poll();
            used.add(new Trio(poll.server, poll.index, time + tasks[i]));
            ans[i] = poll.index;
            i++;
            time++;
            if (i == n) break;
        }
        return ans;
    }

    static record Pair(int server, int index) {
    }

    static record Trio(int server, int index, int tillTime) {
    }
}