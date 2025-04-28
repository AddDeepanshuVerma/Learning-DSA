package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13BellmonFordAlgo {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(1, 2, 4)));
        edges.add(new ArrayList<>(List.of(1, 3, 3)));
        edges.add(new ArrayList<>(List.of(2, 4, 7)));
        edges.add(new ArrayList<>(List.of(3, 4, -2)));
        int[] ans = bellmonFord(4, 4, 1, edges);
        System.out.println(Arrays.toString(ans));
    }

    final static int max = 10000_0000;

    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int[] dis = new int[n + 1];
        Arrays.fill(dis, max);

        dis[src] = 0;
        for (int i = 0; i < n; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if (dis[u] != max && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }
        System.out.println("dis = " + Arrays.toString(dis));

        // now if are able to apply relaxation 1 more time means -ive cycle detected
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = dis[i + 1];
        }
        return res;
    }
}