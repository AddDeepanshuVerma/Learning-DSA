package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Function to find the shortest distance of all the vertices from the source vertex src.
public class _13Dijkstra_Algo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        ArrayList<Pair> node = new ArrayList<>();
        node.add(new Pair(1, 9));
        adj.add(node);

        ArrayList<Pair> node2 = new ArrayList<>();
        node2.add(new Pair(0, 9));
        adj.add(node2);

        System.out.println(dijkstra(adj, 0));
    }

    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        /*
         * KeyPoints :
         * Brief : Dijkstra Algo is nothing but simple BFS but put the element in que again
         * only if we are getting better answer then previous one Where we maintain
         * an array of holding answers (earlier all INT_MAX)
         * */
        int n = adj.size();
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.weight() - b.weight()); //{source, weight}
        q.offer(new Pair(src, 0)); // to go from source to source takes 0 weight, default case to be added
        weight[src] = 0;

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int u = poll.node();
            int w = poll.weight();

            for (Pair pair : adj.get(u)) {
                int v = pair.node();
                int delta = pair.weight();

                if (w + delta < weight[v]) { // we will keep on adding if we are getting the better answer
                    weight[v] = w + delta;
                    q.offer(new Pair(v, w + delta));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int val : weight) res.add(val);

        return res;
    }

    record Pair(int node, int weight) {
    }

}
