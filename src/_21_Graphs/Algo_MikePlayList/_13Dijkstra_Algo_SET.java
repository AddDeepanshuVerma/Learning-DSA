package _21_Graphs.Algo_MikePlayList;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;

public class _13Dijkstra_Algo_SET {

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.getFirst().add(new iPair(1, 9));
        adj.get(0).add(new iPair(2, 1));
        adj.get(0).add(new iPair(3, 1));
        adj.get(1).add(new iPair(3, 3));
        adj.get(2).add(new iPair(3, 2));

        System.out.println(dijkstra(adj, 0));
    }

    @Description("NOTE: IT WOULD NOT WORK in Java's TreeSet as if would not allow duplicates weight here" +
            "Hence We have to use PriorityQueue to store duplicate and get Minimum out of them")
    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> weight = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        TreeSet<iPair> set = new TreeSet<>((a, b) -> !a.second.equals(b.second) ? a.second - b.second : a.first - b.first);
//        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.second - b.second); //{source, second}
        set.add(new iPair(src, 0)); // to go source from source takes 0 second, default case to be added
        weight.set(src, 0);

        while (!set.isEmpty()) {
            iPair poll = set.pollFirst();
            int u = poll.first;
            int w = poll.second;

            for (iPair pair : adj.get(u)) {
                int v = pair.first;
                int delta = pair.second;

                if (w + delta < weight.get(v)) {
//                    set.remove(new iPair(v, weight.get(v)));  // Remove outdated entry
                    weight.set(v, w + delta);
                    boolean added = set.add(new iPair(v, w + delta));
                    System.out.println("added = " + added);
                }
            }
        }

        return weight;
    }

    record iPair(Integer first, Integer second) {}
}
