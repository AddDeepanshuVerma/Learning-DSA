package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class _13Dijkstra_Algo_PQ {

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 10));
        adj.get(0).add(new Pair(4, 3));
        adj.get(1).add(new Pair(2, 2));
        adj.get(4).add(new Pair(1, 4));
        adj.get(4).add(new Pair(2, 8));
        adj.get(2).add(new Pair(3, 9));
        adj.get(3).add(new Pair(2, 7));

        System.out.println(dijkstra(adj, 0));
    }

    /*
     * Definition : "FIND THE SHORTEST PATH FORM A SINGLE SOURCE TO ALL REMAINING VERTICES"
     * KeyPoints :
     * Brief : Dijkstra Algo is nothing but simple BFS but put the element in que again
     * only if we are getting better answer then previous one Where we maintain
     * an array of holding answers (earlier all INT_MAX)
     * */
    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> weight = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.weight - b.weight); //{source, weight}
        q.offer(new Pair(src, 0)); // to go source from source takes 0 second, default case to be added
        weight.set(src, 0);

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int u = poll.node;
            int w = poll.weight;

            for (Pair pair : adj.get(u)) {
                int v = pair.node;
                int delta = pair.weight;

                if (w + delta < weight.get(v)) {
                    weight.set(v, w + delta);
                    q.offer(new Pair(v, w + delta));
                }
            }
        }

        return weight;
    }

    record Pair(Integer node, Integer weight) {
    }
}
