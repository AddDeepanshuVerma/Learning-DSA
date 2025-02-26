package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class _13Dijkstra_Algo_tbd {

    public static void main(String[] args) {
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        ArrayList<iPair> node = new ArrayList<>();
        node.add(new iPair(1, 9));
        adj.add(node);

        ArrayList<iPair> node2 = new ArrayList<>();
        node2.add(new iPair(0, 9));
        adj.add(node2);

        System.out.println(dijkstra(adj, 0));
    }


    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> weight = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        PriorityQueue<iPair> q = new PriorityQueue<>((a, b) -> a.second - b.second); //{source, weight}
        q.offer(new iPair(src, 0)); // to go source from source takes 0 weight, default case to be added
        weight.set(src, 0);

        while (!q.isEmpty()) {
            iPair poll = q.poll();
            int u = poll.first;
            int w = poll.second;

            for (iPair pair : adj.get(u)) {
                int v = pair.first;
                int delta = pair.second;

                if (w + delta < weight.get(v)) {
                    weight.set(v, w + delta);
                    q.offer(new iPair(v, w + delta));
                }
            }
        }

        return weight;
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
